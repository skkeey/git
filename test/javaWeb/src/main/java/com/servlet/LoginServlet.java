package com.servlet;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到jsp页面传过来的参数
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        UserDao userDao = new UserDaoImpl();
        if (userDao.login(name, pwd)) {
            //向request域中放置信息
            req.setAttribute("message", "欢迎用户"+ name);
            //转发到成功页面
            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        } else {
            //重定向到首页
            resp.sendRedirect("index.jsp");
        }
    }
}
