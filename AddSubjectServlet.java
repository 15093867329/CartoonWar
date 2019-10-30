package com.neuedu.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.common.HigherResponse;
import com.neuedu.entity.Subject;
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
import java.util.Arrays;

@WebServlet(name = "AddSubjectServlet" ,urlPatterns = "/addSub.do")
public class AddSubjectServlet extends HttpServlet {
    private SubService subService;

    @Override
    public void init() throws ServletException {
        subService= new SubServiceImpl();
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        String company = req.getParameter("company");
        String companyAddress = req.getParameter("companyAddress");
        String[] subTypes = req.getParameterValues("subType");
        System.out.println("sss"+subTypes);
        String jobName = req.getParameter("jobName");
        String level = req.getParameter("level");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("userInfo");
        if (null==user){
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "登录过期，重新登录");
            String s = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(s);
            return;
        }
        String reSubType = Arrays.toString(subTypes).replace("[", "").replace("]", "").replace(" ", "");
        System.out.println(reSubType);
        Integer id = user.getId();
        System.out.println(level);
        int changeLevel = Integer.parseInt(level);
        System.out.println(changeLevel);
        Subject subject = new Subject(null, url, company, companyAddress, reSubType, jobName, id, changeLevel, null, null, null);
        Integer integer = subService.addOneSubject(subject);
        if (integer>0){
            HigherResponse higherResponse = new HigherResponse(1, "添加成功");
            String s = JSONObject.toJSONString(higherResponse);
            resp.getWriter().write(s);
            System.out.println(s);
            return;
        }else {
            HigherResponse higherResponse = new HigherResponse(0, "添加失败");
            String s = JSONObject.toJSONString(higherResponse);
            resp.getWriter().write(s);
            return;
        }
    }
}
