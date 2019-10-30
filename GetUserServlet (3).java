package com.neuedu.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.common.HigherResponse;
import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GetUserServlet",urlPatterns = "/user/getUser.do")
public class GetUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userInfo = (User)session.getAttribute("userInfo");
        if(null == userInfo){
            HigherResponse<Object> res = new HigherResponse<>(0, "用户未登录");
            String s = JSONObject.toJSONString(res);
            resp.getWriter().write(s);
            return;
        }else{
            HigherResponse<User> userHigherResponse = new HigherResponse<>(1, userInfo);
            String s = JSONObject.toJSONString(userHigherResponse);
            resp.getWriter().write(s);
            return;
        }
    }
}
