package com.neuedu.dao;

import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProDaoImpl implements ProDao {
    @Override
    public boolean addOneproduct(Product product) {
        Connection connection = DBUtils.getConnection();
        System.out.println(connection);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO neuedu_product(category_id,name,detail,subtitle,main_image,price,stock,status,create_time,update_time) VALUES (?,?,?,?,?,?,?,?,NOW(),NOW())");
            preparedStatement.setInt(1,product.getCategoryId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3,product.getDetail());
            preparedStatement.setString(4,product.getSubTitle());
            preparedStatement.setString(5,   product.getMainImage());
            preparedStatement.setBigDecimal(6,product.getPrice());
            preparedStatement.setInt(7,product.getStock());
            preparedStatement.setByte(8,product.getStatus());
            int result = preparedStatement.executeUpdate();
            if (result > 0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResource(null,preparedStatement,connection);
        }


        return false;
    }

    @Override
    public List<Product> getALLPro() {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ArrayList<Product> objects = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT id,category_id,name,detail,subtitle,main_image,price,stock,status,create_time,update_time FROM neuedu_product");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int category_id = resultSet.getInt("category_id");
                String name = resultSet.getString("name");
                String detail = resultSet.getString("detail");
                String subtitle = resultSet.getString("subtitle");
                String main_image = resultSet.getString("main_image");
                BigDecimal price = resultSet.getBigDecimal("price");
                int stock = resultSet.getInt("stock");
                Byte status = resultSet.getByte("status");
                Timestamp create_time = resultSet.getTimestamp("create_time");
                Timestamp update_time = resultSet.getTimestamp("update_time");
                Product product = new Product(id, category_id, name, detail, subtitle, main_image, price, stock, status, create_time, update_time);
                objects.add(product);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResource(resultSet,preparedStatement,connection);
        }
        return objects;
    }
}
