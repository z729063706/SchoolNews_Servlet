package com.dao;

import java.sql.SQLException;

import com.util.c3p0Util;

import org.apache.commons.dbutils.QueryRunner;

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
}
