package com.neuedu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
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
        String name = req.getParameter("name");
        String psw = req.getParameter("psw");
        if("".equals(name) || name.length() == 0){
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "输入错误！");
            String s = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(s);
            return;
        }
        if("".equals(psw) || psw.length() == 0){
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "输入错误！");
            String s = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(s);
            return;
        }
        User user = new User();
        user.setPhone(name);
        user.setPassword(psw);
        User login = userService.login(user);
        if(null != login){
            // 将登陆成功用户信息放到session
            HttpSession session = req.getSession();
            session.setAttribute("userInfo",login);
            HigherResponse<User> userHigherResponse = new HigherResponse<>(1, login);
            String s = JSONObject.toJSONString(userHigherResponse);
            resp.getWriter().write(s);
            return;
        }else{
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "用户不存在！");
            String s = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(s);
            return;
        }
    }
}
