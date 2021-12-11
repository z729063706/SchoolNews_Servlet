package com.conctoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dao.logDao;
import com.dao.userDao;
import com.util.JsonUtil;


@WebServlet("/api/useradd")
public class userAddContorller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JSONObject json = JsonUtil.getRequestJsonObject(req);
        PrintWriter out = resp.getWriter();
        String uname = json.getString("uname");
        String upass = json.getString("upass");
        Integer utype = userDao.getDetail(userDao.checkUser(uname, upass)).getUtype();
        if (utype<5){
            resp.setStatus(403);
            out.print("{error:用户权限不足!!}");
            out.flush();
            return;
        }
        try {
            String newuname = json.getString("newusername");
            String newpass = json.getString("newpassword");
            String newname = json.getString("newname");
            logDao.log(uname, "creat user "+newname);
            userDao.addUser(newuname, newname, newpass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.print("{msg:添加成功}");
        out.flush();
        return;
    }
}
