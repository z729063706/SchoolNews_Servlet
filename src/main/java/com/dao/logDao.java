package com.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.Log;
import com.util.c3p0Util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class logDao {
    public static void log(String uname, String action){
        String sql = " INSERT INTO LOGS(UNAME,ACTION) VALUES (?,?) ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        try {
            qr.update(sql,uname,action);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Integer getLoginCount(){
        String sql = " SELECT COUNT(*) FROM LOGS WHERE ACTION ='Login' ";
        Integer re = -1;
        try {
            Connection conn = c3p0Util.getConnection();
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            while(rs.next()){
                re = rs.getInt("COUNT(*)");
            }
            c3p0Util.closeAll(conn, prst);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return re;
    }
    public static List<Log> getLogs(Integer limit){
        List<Log> re = null;
        String sql = " SELECT * FROM LOGS ORDER BY TIME DESC LIMIT ?";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        ResultSetHandler<List<Log>> rsh = new BeanListHandler<Log>(Log.class);
        try {
            re = qr.query(sql,rsh,limit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return re;
    }
}
