package com.neuedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
* @ClassName: TestJdbc5
* @Description:prepareStatement 删除
* @author cps
* @date 2019年9月11日 上午10:25:52
*
*/
public class TestJdbc5 {
	public static void main(String[] args) {
		boolean deleteOneCourse = new TestJdbc5().DeleteOneCourse(10);
		System.out.println(deleteOneCourse);
	}
	public boolean DeleteOneCourse(int cid) {
		PreparedStatement prepareStatement =null;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?useSSL=false", "root", "123456");
		    prepareStatement = connection.prepareStatement("delete FROM course WHERE cid=?");
			prepareStatement.setInt(1, cid);
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
			if(null!= prepareStatement) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null!= connection) {
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
