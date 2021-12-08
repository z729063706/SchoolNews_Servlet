package com.conctoller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.logDao;
import com.dao.newsDao;
import com.dao.userDao;

@WebServlet("/api/delnews")
public class newsDelContorller extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");
        String action = "del news "+id;
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
        newsDao.delNews(id);
        out.write("{msg:done}".getBytes("UTF-8"));
        out.flush();
    }
}
