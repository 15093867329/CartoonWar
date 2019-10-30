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
        if (userInfo==null){
            HigherResponse higherResponse = new HigherResponse(0, "用户未登录");
            String s = JSONObject.toJSONString(higherResponse);
            resp.getWriter().write(s);
            return;
        }else {
          HigherResponse str=new HigherResponse(1,userInfo);
            String s = JSONObject.toJSONString(str);
            resp.getWriter().write(s);
            return;
        }

    }
}
