package com.neuedu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.neuedu.common.HigherResponse;
import com.neuedu.entity.Subject;
import com.neuedu.service.SubService;
import com.neuedu.service.SubServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdataServlet",urlPatterns = "/user/update.do")
public class UpdataServlet extends HttpServlet {
    private SubService subService;

    @Override
    public void init() throws ServletException {
        subService = new SubServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        int i = Integer.parseInt(sid);
        Subject subject = subService.querySubjectById(i);
        if (null==subject){
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "该数据已失效");
            String s = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(s);
            return;
        }else {
            HigherResponse<Subject> subjectHigherResponse = new HigherResponse<>(1, subject);
            String s = JSONObject.toJSONString(subjectHigherResponse, SerializerFeature.WriteDateUseDateFormat);
            resp.getWriter().write(s);
            return;
        }
    }
}
