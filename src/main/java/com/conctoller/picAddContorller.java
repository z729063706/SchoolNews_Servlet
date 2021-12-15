package com.conctoller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dao.logDao;
import com.dao.mianpicDao;
import com.dao.newsDao;
import com.dao.userDao;
import com.util.JsonUtil;

@WebServlet("/api/addpic")
public class picAddContorller extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject json = JsonUtil.getRequestJsonObject(req);
        String url = json.getString("picurl");
        String content = json.getString("piccontent");
        String uname = json.getString("uname");
        String upass = json.getString("upass");
        String action = "add pic "+url;
        OutputStream out = resp.getOutputStream();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Integer utype = userDao.getDetail(userDao.checkUser(uname, upass)).getUtype();
        if (utype < 10){
            resp.setStatus(403);
            out.write("{msg:error}".getBytes("UTF-8"));
            out.flush();
            return;
        }        
        logDao.log(uname,action);
        if (mianpicDao.addMainpic(url, content)){
            out.write("{msg:done}".getBytes("UTF-8"));
        }
        else{
            resp.setStatus(403);
        }
        out.flush();
    }
}
