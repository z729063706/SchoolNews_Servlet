package com.conctoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bean.News;
import com.dao.logDao;
import com.dao.newsDao;
import com.dao.userDao;
import com.util.JsonUtil;


@WebServlet("/api/newsadd")
public class newsInsertContorller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        News news = new News();
        JSONObject json = JsonUtil.getRequestJsonObject(req);
        PrintWriter out = resp.getWriter();
        String uname = json.getString("uname");
        String upass = json.getString("upass");
        news.setTitle(json.getString("title"));
        news.setContent(json.getString("content"));
        news.setAuther(json.getString("auther"));
        news.setPic(json.getString("mainpic"));
        news.setType(Integer.parseInt(json.getString("type")));
        Integer utype = userDao.getDetail(userDao.checkUser(uname, upass)).getUtype();
        if (utype<5){
            resp.setStatus(403);
            out.print("{error:用户权限不足!!}");
            out.flush();
            return;
        }
        Integer newsid = newsDao.insertNews(news);
        logDao.log(uname, "add news "+newsid);
        out.print(newsid); 
        out.flush();
        return;
    }
}
