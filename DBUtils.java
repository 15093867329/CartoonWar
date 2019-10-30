package com.neuedu.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName: DBUtils
 * @Description: 数据库工具类
 * @author cps
 * @date 2019年9月9日 下午2:55:49
 *
 */
public class DBUtils {
    //读取配置文件
    private static Properties prop;
    static {
        prop = new Properties();
        try {
            prop.load(DBUtils.class.getResourceAsStream("/mysql.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // 获取连接的方法
    public static Connection getConnection() {
        try {
            Class.forName(prop.getProperty("driverClass"));
            Connection connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("psw"));
            if(null != connection) {
                return connection;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;











    }
    //统一关闭资源的方法
    public static void closeResource(ResultSet rs,Statement statement,Connection connection) {
        if(null!=rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=statement) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
