package com.neuedu.controller;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
   private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao=new UserDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 获取网址上的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean b = false;
        //验证用户名密码
        if (username!=null&password!=null){
        b = userDao.queryUserByNameAndPsw(username, password);
        }
        if (b){
            req.getRequestDispatcher("/pages/index.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/pages/denglu.jsp").forward(req,resp);
        }
    }
}
