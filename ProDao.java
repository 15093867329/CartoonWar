package com.neuedu.dao;

import com.neuedu.entity.Product;

import java.util.List;

/**
*商品dao
* */
public interface ProDao {
    boolean addOneproduct(Product product);
    List<Product> getALLPro();
}
