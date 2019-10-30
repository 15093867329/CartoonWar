package com.neuedu.dao;

import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean queryUserByNameAndPsw(String username, String password) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        try {
            preparedStatement = connection.prepareStatement("SELECT username,password FROM neuedu_user WHERE username=? and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResource(resultSet,preparedStatement,connection);
        }

        return false;
    }
}
