package com.conctoller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bean.User;
import com.dao.logDao;
import com.dao.userDao;

@WebServlet("/api/login")
public class loginContorller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");
        Integer uid = userDao.checkUser(uname, upass);
        OutputStream out = resp.getOutputStream();
        if (uid > 0){
            User user = userDao.getDetail(uid);
            resp.setCharacterEncoding("UTF-8");
            logDao.log(user.getUname(), "Login");
            out.write(JSONObject.toJSONString(user).getBytes("UTF-8"));
            out.flush();
        }
        else{
            resp.setCharacterEncoding("UTF-8");
            //resp.setStatus(403);
            out.write("用户名或密码错误".getBytes("UTF-8"));
            out.flush();
        }
        

        
    }
    
}
