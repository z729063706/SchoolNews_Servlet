package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.Mainpic;
import com.util.c3p0Util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class mianpicDao {
    public static List<Mainpic> getMainpicList(){
        List<Mainpic> re = null;
        String sql = " SELECT * FROM MAINPIC ORDER BY INSERTTIME DESC ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        ResultSetHandler<List<Mainpic>> rsh = new BeanListHandler<Mainpic>(Mainpic.class);
        try {
            re = qr.query(sql, rsh);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return re;
    }
    public static Boolean delMainpic(Integer id){
        String sql = " DELETE FROM MAINPIC WHERE ID=? ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        try {
            qr.execute(sql, id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean switchMainpic(Integer id){
        String sql = " UPDATE MAINPIC SET VAILD = NOT vaild WHERE id=? ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        try {
            qr.execute(sql, id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean addMainpic(String url, String content){
        String sql = " INSERT INTO MAINPIC(URL,CONTENT) VALUES (?,?) ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        try {
            qr.execute(sql, url, content);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
