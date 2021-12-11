package com.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.News;
import com.util.c3p0Util;
import com.util.htmlUtil;
import com.util.nameShorter;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class newsDao {
    public static List<News> getNews(Integer tp, Integer limit){
        String sql = " SELECT ID,TITLE,PIC,SHORTCONTENT,TYPE,CREATTIME,AUTHER FROM NEWS WHERE TYPE=? ORDER BY CREATTIME DESC LIMIT ? ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        List<News> res = null;
        ResultSetHandler<List<News>> rsh = new BeanListHandler<News>(News.class);
        try {
            res = qr.query(sql, rsh, tp, limit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public static int insertNews(News news){
        String sql1 = " INSERT INTO NEWS(TITLE,PIC,CONTENT,TYPE,AUTHER,SHORTCONTENT) VALUES (?,?,?,?,?,?) ";
        String sql2 = " SELECT @@IDENTITY ";
        news.setShortContent(nameShorter.getShortString(htmlUtil.convert(news.getContent()), 150));
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        BigInteger newsid = null;
        try {
            qr.update(sql1,news.getTitle(),news.getPic(),news.getContent(),news.getType(),news.getAuther(),news.getShortContent());
            newsid= (BigInteger) qr.query(sql2, new ScalarHandler(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (newsid == null){
            return -1;
        }
        return newsid.intValue();
    }
    public static News getDetail(Integer id){
        News re = new News();
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        ResultSetHandler<News> rsh = new BeanHandler<News>(News.class);
        String sql = "SELECT * FROM NEWS WHERE ID=?";
        try {
            re = qr.query(sql, rsh, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return re;
    }
    public static boolean delNews(Integer id){
        String sql = " DELETE FROM NEWS WHERE ID = ? ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
