package com.neuedu.controller;

import com.alibaba.fastjson.JSONObject;
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
import java.util.Arrays;

@WebServlet(name = "renewServlet",urlPatterns = "/user/renew.do")
public class renewServlet extends HttpServlet {

    private SubService subService;

    @Override
    public void init() throws ServletException {
        subService = new SubServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        String url = req.getParameter("url");
        String company = req.getParameter("company");
        String companyAddress = req.getParameter("companyAddress");
        String[] subTypes = req.getParameterValues("subType");
        String jobName = req.getParameter("jobName");
        String level = req.getParameter("level");
        String reSubType = Arrays.toString(subTypes).replace("[", "").replace("]", "").replace(" ", "");
//        int sid = Integer.parseInt(id);
        int i = Integer.parseInt(level);
        System.out.println("sid"+sid);
        System.out.println("url"+url);
        System.out.println("company"+company);
        System.out.println("companyAddress"+companyAddress);
        System.out.println("reSUB"+reSubType);
        System.out.println("job"+jobName);
        System.out.println("lever"+i);
        Subject subject = new Subject(sid,url,company,companyAddress,reSubType,jobName,null,i,null,null,null);
        System.out.println("ssss"+subject);
        boolean b = subService.updateSubjectById(subject);
        System.out.println(b);
        if(b){
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(1, "修改成功");
            String string = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(string);
            return;
        }else {
            HigherResponse<Object> objectHigherResponse = new HigherResponse<>(0, "修改失败");
            String string = JSONObject.toJSONString(objectHigherResponse);
            resp.getWriter().write(string);
            return;
        }

    }
}
