package com.neuedu.controller;

import com.neuedu.dao.ProDao;
import com.neuedu.dao.ProDaoImpl;
import com.neuedu.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryShopServlet",urlPatterns = "/query.do")
public class QueryShopServlet extends HttpServlet {
    private ProDao proDao;

    @Override
    public void init() throws ServletException {
        proDao = new ProDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询所有商品
        List<Product> allPro = proDao.getALLPro();
        req.setAttribute("shops",allPro);
        req.getRequestDispatcher("pages/allShop.jsp").forward(req,resp);
    }
}
