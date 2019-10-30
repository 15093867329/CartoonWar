package com.neuedu.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.common.HigherResponse;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = "/user/login.do")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    private UserService userService;
    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String pass = req.getParameter("pass");
        System.out.println("-----------"+phone);
        System.out.println("-----------"+pass);
        if ("".equals(phone) || phone == null){
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "输入错误");
            String s = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(s);
            return;
        }
        if ("".equals(pass) || pass == null){
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "输入错误");
            String s = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(s);
            return;
        }
        User user = new User();
        user.setPhone(phone);
        user.setPassword(pass);
        User login = userService.login(user);
        System.out.println(login);
        if (null != login){
            HttpSession session = req.getSession();
            session.setAttribute("userInfo",login);
            HigherResponse<User> userHigherResponse = new HigherResponse<>(1, login);
            String s = JSONObject.toJSONString(userHigherResponse);
            resp.getWriter().write(s);
            return;
        }else {
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "用户不存在！！");
            String s = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(s);
            return;
        }
    }
}
