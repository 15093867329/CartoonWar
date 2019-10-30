package com.neuedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PerConnectionLRUFactory;
import com.neuedu.entity.Course;
import com.neuedu.utils.DBUtils;

/**
* @ClassName: TestJdbc3
* @Description: 分页查询
* @author cps
* @date 2019年9月10日 下午8:20:24
*
*/
public class TestJdbc3 {
    public static void main(String[] args) {
		List<Course> pagingQuery = new TestJdbc3().getPagingQuery(0, 4);
		System.out.println(pagingQuery);
		
	}
    public List<Course> getPagingQuery(int start,int pageSize) {
    	ResultSet rs =null;
    	PreparedStatement prepareStatement =null;
    	Connection connection =null;
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?useSSL=false", "root", "123456");
			prepareStatement = connection.prepareStatement("SELECT cid,cname,tname,sid FROM course LIMIT ?,? ");
			prepareStatement.setInt(1, start);
			prepareStatement.setInt(2, pageSize);
			rs = prepareStatement.executeQuery();
			ArrayList<Course> arrayList = new ArrayList<Course>();
			while(rs.next()) {
				int id = rs.getInt("cid");
				String name = rs.getString("cname");
				String name2 = rs.getString("tname");
				int sid = rs.getInt("sid");
				Course course = new Course(id,name,name2,sid);
				arrayList.add(course);
			}
			return arrayList;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
    		DBUtils.closeResource(rs, prepareStatement, connection);
    	}
    	return null;
    }
}
