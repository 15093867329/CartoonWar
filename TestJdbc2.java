package com.neuedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.neuedu.entity.Course;
import com.neuedu.utils.DBUtils;

/**
* @ClassName: TestJdbc2
* @Description: ��Ӳ���
* @author cps
* @date 2019��9��7�� ����11:01:13
*
*/
public class TestJdbc2 {
	public static void main(String[] args) {
		Course course = new Course(007, "html","ALLen" , 007);
		boolean addOneCourse = new TestJdbc2().addOneCourse(course);
		System.out.println(addOneCourse);
	}
    // ��װ
	private boolean addOneCourse(Course c) {
    	Statement createStatement=null;
    	Connection connection =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ����
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?useSSL=false", "root", "123456");
			// SQL���
			//INSERT INTO course VALUES (001,'mysql','mr.white',123);
			String sql = "INSERT INTO course VALUES("+ c.getcId()+",'"+c.getcName()+"','"+c.gettName()+"',"+c.getsId()+")";
			//����ִ��SQL�Ķ���
		      createStatement =	connection.createStatement();
		   //ִ��SQL���
		   int executeUpdate =createStatement.executeUpdate(sql);
		   if(0!=executeUpdate) {
			   return true;
		   }
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeResource(null, createStatement, connection);
		}

		return false;
	}
}
