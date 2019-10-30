package com.neuedu.controller;

import com.alibaba.fastjson.JSON;
import com.neuedu.common.HigherResponse;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet" ,urlPatterns = "/user/register.do")
public class RegisterServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String nickName = req.getParameter("nickname");
        String password = req.getParameter("password");
        String realName = req.getParameter("realName");
        User user = new User(null, phone, password, nickName, realName, 0, null, null, null);
        boolean b = userService.registerUser(user);

            if (b){
                HigherResponse<Object> hp = new HigherResponse<>(1, "注册成功");
                String s = JSON.toJSONString(hp);
                resp.getWriter().write(s);
                return;
            }else {
                HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "发生未知错误，注册失败");
                String s = JSON.toJSONString(objectHigherResponse);
                resp.getWriter().write(s);
                return;
            }

    }
}
