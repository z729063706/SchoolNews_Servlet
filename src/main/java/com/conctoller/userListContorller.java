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
import com.bean.User;
import com.dao.userDao;

@WebServlet("/api/getuserlist")
public class userListContorller extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");
        Integer uid = userDao.checkUser(uname, upass);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        if (uid < 0){
            resp.setStatus(403);
            out.print("{error:用户状态异常!}");
            out.flush();
            return;
        }
        List<User> res = userDao.userList(uid);
        JSONArray newsJsonArray = new JSONArray();
        newsJsonArray = JSONArray.parseArray(JSONObject.toJSONString(res));
        out.print(newsJsonArray);
        out.flush();
        return;
    }
}
