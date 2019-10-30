package com.neuedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.neuedu.entity.Course;

/**
* @ClassName: TestJdbc4
* @Description: prepareStatement 增加数据
* @author cps
* @date 2019年9月11日 上午10:22:42
*
*/
public class TestJdbc4 {
	
	public static void main(String[] args) {
		boolean addOneCourse = new TestJdbc4().addOneCourse(10, "Tom", "javascript", 10);
		System.out.println(addOneCourse);
	}
    private boolean addOneCourse(int cid,String cname,String tname,int sid) {
    	PreparedStatement prepareStatement = null;
    	Connection connection = null;
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?useSSL=false", "root", "123456");
		    prepareStatement = connection.prepareStatement("INSERT INTO course VALUES(?,?,?,?)");
		
			prepareStatement.setInt(1, cid);
			prepareStatement.setString(2, cname);
			prepareStatement.setString(3, tname);
			prepareStatement.setInt(4, sid);
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
			if(null!=prepareStatement) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null!=connection) {
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
