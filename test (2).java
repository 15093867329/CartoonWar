package com.neuedu.dao;

import com.neuedu.entity.Product;

import java.util.List;

public class test {
    public static void main(String[] args) {
        ProDaoImpl proDao = new ProDaoImpl();
        List<Product> allPro = proDao.getALLPro();
        System.out.println(allPro);
    }
}
