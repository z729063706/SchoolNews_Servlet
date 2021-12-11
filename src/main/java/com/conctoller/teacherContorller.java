package com.conctoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.Teacher;
import com.dao.teacherDao;

@WebServlet("/api/teacher")
public class teacherContorller extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> res = teacherDao.getTeacherList();
        JSONArray newsJsonArray = new JSONArray();
        newsJsonArray = JSONArray.parseArray(JSONObject.toJSONString(res));
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(newsJsonArray);
    }
}
