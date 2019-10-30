package com.neuedu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import com.neuedu.common.HigherResponse;
import com.neuedu.entity.User;
import com.neuedu.service.SubService;
import com.neuedu.service.SubServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PageServlet",urlPatterns = "/user/page.do")
public class PageServlet extends HttpServlet {
    private SubService subService;

    @Override
    public void init() throws ServletException {
        subService= new SubServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
//        int pageNum2 = 1;
//        int pageSize2 = 5;
//        if (null!=pageNum){
         int    pageNum2=Integer.parseInt(pageNum);
//        }
//        if (null!=pageSize){
       int     pageSize2=Integer.parseInt(pageSize);
//        }

        HttpSession session = req.getSession();
        User userInfo = (User) session.getAttribute("userInfo");
        if (null==userInfo){
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "用户未登录");
            String s = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(s);
            return;
        }else{
            PageInfo pageInfo = subService.querySubjectByPage(userInfo, pageNum2, pageSize2);
            HigherResponse<PageInfo> pageInfoHigherResponse = new HigherResponse<>(1, pageInfo);
            String s = JSONObject.toJSONString(pageInfoHigherResponse, SerializerFeature.WriteDateUseDateFormat);
            resp.getWriter().write(s);
            return;
        }
    }
}
