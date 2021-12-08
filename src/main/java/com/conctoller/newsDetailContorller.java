package com.conctoller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.News;
import com.dao.newsDao;

@WebServlet("/api/getnews")
public class newsDetailContorller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        News res = newsDao.getDetail(id);
        resp.setCharacterEncoding("UTF-8");
        OutputStream out = resp.getOutputStream();

        out.write(JSONObject.toJSONString(res).getBytes("UTF-8"));
        out.flush();
    }
}
