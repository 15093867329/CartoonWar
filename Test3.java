package com.neuedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* @ClassName: Test3
* @Description: prepareStatement 查询
* @author cps
* @date 2019年9月11日 上午10:24:13
*
*/
public class Test3 {
	public static void main(String[] args) {
		ResultSet executeQuery = null;
		Statement createStatement =null;
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?useSSL=false", "root", "123456");
			//connection.prepareStatement("SELECT cid,cname,tname,sid FROM course");
			String sql=("SELECT cid,cname,tname,sid FROM course");
		    createStatement = connection.createStatement();
			executeQuery = createStatement.executeQuery(sql);
			while(executeQuery.next()) {
				int id=executeQuery.getInt(1);
				String cname = executeQuery.getString(2);
				String tname = executeQuery.getString(3);
				int sid=executeQuery.getInt(4);
				System.out.println(id+"-"+cname+"-"+tname+"-"+sid);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(null !=executeQuery) {
				try {
					executeQuery.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null !=createStatement) {
				try {
					createStatement.close();
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
	}

}
