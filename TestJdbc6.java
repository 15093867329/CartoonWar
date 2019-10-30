package com.neuedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
* @ClassName: TestJdbc6
* @Description: prepareStatement 修改
* @author cps
* @date 2019年9月11日 上午10:56:04
*
*/
public class TestJdbc6 {
	public static void main(String[] args) {
		boolean updateOneCourse = new TestJdbc6().updateOneCourse("sqlsever", "Steven", 4);
		System.out.println(updateOneCourse);
	}
    public boolean updateOneCourse(String cname,String tname ,int sid) {
    	PreparedStatement prepareStatement = null;
    	Connection connection =null;
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?useSSL=false", "root", "123456");
			prepareStatement = connection.prepareStatement("UPDATE course SET cname=?,tname=? WHERE sid=?");
			prepareStatement.setString(1, cname);
			prepareStatement.setString(2, tname);
			prepareStatement.setInt(3, sid);
			int executeUpdate = prepareStatement.executeUpdate();
			if(0!=executeUpdate) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null !=prepareStatement) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null !=connection) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    	
    	return false;
    }
}
