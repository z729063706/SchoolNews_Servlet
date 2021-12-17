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
import com.bean.Log;
import com.dao.logDao;


@WebServlet("/api/getlog")
public class logContorller extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer limit = Integer.parseInt(req.getParameter("limit"));
        List<Log> logs = logDao.getLogs(limit);
        JSONArray newsJsonArray = new JSONArray();
        newsJsonArray = JSONArray.parseArray(JSONObject.toJSONString(logs));
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(newsJsonArray);
    }
}
