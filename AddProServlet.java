package com.neuedu.controller;

import com.neuedu.dao.ProDao;
import com.neuedu.dao.ProDaoImpl;
import com.neuedu.entity.Product;
import com.neuedu.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;

@MultipartConfig
@WebServlet(name = "AddProServlet",urlPatterns = "/addPro.do")
public class AddProServlet extends HttpServlet {
    private ProDao proDao;
    @Override
    public void init() throws ServletException {
        proDao = new ProDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");
        String proName = req.getParameter("proName");
        String proDetail = req.getParameter("proDetail");
        String proSubTitle = req.getParameter("proSubTitle");
        String proPrice = req.getParameter("proPrice");
        String proStock = req.getParameter("proStock");
        String proStatus = req.getParameter("proStatus");
        Part exampleInputFile = req.getPart("exampleInputFile");
        System.out.println(proDetail);
        String submittedFileName = exampleInputFile.getSubmittedFileName();
        // 拿到图片后缀名
        String[] split = submittedFileName.split("\\.");
        String typeName = split[split.length-1];
        // 设置生成图片名的规则
        String newImgName = System.currentTimeMillis()+proName+ new Random().nextInt(1000)+"."+typeName;
        // 转换格式
        int changedCId = Integer.parseInt(categoryId);
        BigDecimal bigDecimal = new BigDecimal(proPrice);
        int changedStock = Integer.parseInt(proStock);
        byte changedStatus = Byte.parseByte(proStatus);
        try {
            Product product = new Product(null, changedCId, proName, proDetail, proSubTitle, newImgName, bigDecimal, changedStock, changedStatus, null, null);
            boolean b = proDao.addOneproduct(product);
            if (b){
                FileUtils.storFile(exampleInputFile.getInputStream(),newImgName);
                // /pages/success.jsp
                req.getRequestDispatcher("pages/addPro.jsp").forward(req,resp);
            }else{
                req.getRequestDispatcher("/addPro.jsp").forward(req,resp);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
