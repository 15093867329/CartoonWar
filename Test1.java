package com.neuedu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.entity.User;
import com.neuedu.utils.DBUtils;

/**
* @ClassName: Test1
* @Description: JDBC中的preparedstatement
* @author cps
* @date 2019年9月10日 下午6:11:03
*
*/
public class Test1 {
	
	public static void main(String[] args) {
		List<User> user = new Test1().getUser("Tom", "neuedu");
		System.out.println(user);
	}
	
	
	
	
	public List<User> getUser(String userName,String psw ) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet rs =null;
		ArrayList<User> arrayList = null;
	
		try {
			 prepareStatement = connection.prepareStatement("SELECT user_id, user_name,user_psw,user_questoin,user_answer FROM user WHERE user_name = ? AND user_psw = ?");
			prepareStatement.setString(1,userName);
			prepareStatement.setString(2, psw);
		    rs = prepareStatement.executeQuery();
	         arrayList = new ArrayList<User>();
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				String psw2 = rs.getString("user_psw");
				String ques = rs.getString("user_questoin");
				String ans = rs.getString("user_answer");
				User user=new User(id,name,psw2,ques,ans);
				arrayList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeResource(rs, prepareStatement, connection);
		}
		 return arrayList;
	}

  }

