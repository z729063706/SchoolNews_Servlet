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
}
