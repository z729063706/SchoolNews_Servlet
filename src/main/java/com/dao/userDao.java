package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.User;
import com.util.c3p0Util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


public class userDao {
    public static Integer checkUser(String uname, String upass){
        String sql = " SELECT UID FROM USER WHERE UNAME = ? AND UPASS = ? ";
        Integer re = -1;
        Connection conn = null;
        PreparedStatement prst = null; 
        ResultSet res = null;
        try {
            conn = c3p0Util.getConnection();
            prst = conn.prepareStatement(sql);
            prst.setString(1, uname);
            prst.setString(2, upass);
            res = prst.executeQuery();
            Integer total = 0;
            while(res.next()){
                re = res.getInt("UID");
                total = total + 1;
                if (total>1){
                    return -111;
                }
            }            
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c3p0Util.closeAll(conn, prst);

        return re;
    }
    
    public static User getDetail(Integer uid){
        User user = new User();
        String sql = " SELECT * FROM USER WHERE UID = ? ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        ResultSetHandler<User> rsh = new BeanHandler<User>(User.class);
        try {
            user = qr.query(sql, rsh, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //logDao.log(user.getUname(), "Login");
        return user;
    }
    public static List<User> userList(Integer uid){
        String sql = "SELECT UID,NAME,UNAME,UTYPE,REGTIME FROM USER";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        List<User> res = null;
        ResultSetHandler<List<User>> rsh = new BeanListHandler<User>(User.class);
        Integer utype = userDao.getDetail(uid).getUtype();
        try {
            res = qr.query(sql, rsh);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (User u:res){
                u.setIsChild(utype >= u.getUtype());
        }
        return res;
    }
    public static void updatePass(Integer uid, String newpass){
        String sql = " UPDATE USER SET UPASS=? where uid=? ";
        Connection conn = null;
        PreparedStatement prst = null; 
        try {
            conn = c3p0Util.getConnection();
            prst = conn.prepareStatement(sql);
            prst.setString(1, newpass);
            prst.setInt(2, uid);
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c3p0Util.closeAll(conn, prst);
    }
    public static void delUser(Integer uid){
        String sql = " DELETE FROM USER WHERE uid=? "; 
        Connection conn = null;
        PreparedStatement prst = null; 
        try {
            conn = c3p0Util.getConnection();
            prst = conn.prepareStatement(sql);
            prst.setInt(1, uid);
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c3p0Util.closeAll(conn, prst);
    }
    public static Boolean addUser(String uname,String name,String upass){
        String sql = " INSERT INTO USER(UNAME,NAME,UPASS,UTYPE) VALUES (?,?,?,1) ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        try {
            qr.execute(sql, uname, name, upass);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}