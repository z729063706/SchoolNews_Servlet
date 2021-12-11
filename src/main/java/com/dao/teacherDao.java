package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.Teacher;
import com.util.c3p0Util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class teacherDao {
    public static void insertTeacher(Teacher t){
        String sql = " INSERT INTO TEACHER(NAME,ZHICHENG,MAINPIC,DETAIL) VALUES (?,?,?,?) " ;
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        try {
            qr.execute(sql, t.getName(), t.getZhicheng(),t.getMainpic(),t.getDetail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
    public static Teacher getTeacherDetail(Integer id){
        String sql = " SELECT * FROM TEACHER WHERE ID = ? ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        ResultSetHandler<Teacher> rsh = new BeanHandler<Teacher>(Teacher.class);
        Teacher t = null;
        try {
            t = qr.query(sql, rsh, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public static List<Teacher> getTeacherList(){
        String sql = " SELECT ID,NAME,ZHICHENG,MAINPIC FROM TEACHER ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        ResultSetHandler<List<Teacher>> rsh = new BeanListHandler<Teacher>(Teacher.class);
        List<Teacher> re = null;
        try {
            re = qr.query(sql, rsh);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return re;
    }
}
