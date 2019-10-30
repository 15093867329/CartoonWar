package com.neuedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.entity.Course;
import com.neuedu.utils.DBUtils;

/**
* @ClassName: TestJdbc
* @Description: 操作JDBC
* @author cps
* @date 2019年9月6日 下午7:55:10
*
*/
public class TestJdbc {
	/*
	 * step.1 需要导包
       step.2 加载驱动
       step.3 获取连接
       step.4 执行SQL语句
       step.5 返回查询结果
       step.6 输出查询结果
       step.7 关闭连接
	 */
    public static void main(String[] args) {
    	Course course = new Course(null,null,null,null);
	    List<Course> queryCoursesByCondition = new TestJdbc().queryCoursesByCondition(course);
    	}
    // 查询数据
    public List<Course>queryAllCourses(){
    	// step.2 加载驱动  = 程序 = 代码
    	// 反射
    	ResultSet rs=null;
    	Statement createStatement=null;
    	Connection connection =null;
    	ArrayList<Course> arrayList =null;
			try {
				  connection = DBUtils.getConnection();
		    	// SQL语句
		    	String sql = "SELECT cid,cname,tname,sid FROM course";
		    	// step.4 执行SQL语句
		    	 createStatement =connection.createStatement();
		    	// 执行结果返回到set里   ResultSet为接口 
		    	//createStatement.executeQuery(sql)是ResultSet executeQuery实现类（转型）
		    	rs = createStatement.executeQuery(sql);
		    	//step.6 输出查询结果
		    	//创建容器 List
		       arrayList = new ArrayList<Course>();
		    	while(rs.next()) {
		    		int id = rs.getInt(1);
		    		String cname = rs.getString(2);
		    		String tname = rs.getString(3);
		    		int sid = rs.getInt(4);
		    		Course course = new Course(id, cname, tname, sid);
		    		arrayList.add(course);
		    	}	
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				DBUtils.closeResource(rs, createStatement, connection);
			} 

    	return arrayList;
       } 
    // 单条件查询数据
    public List<Course>queryAllCourses(String tName){
    	// step.2 加载驱动  = 程序 = 代码
    	// 反射
    	ResultSet rs=null;
    	Statement createStatement=null;
    	Connection connection =null;
    	ArrayList<Course> arrayList =null;
			try {
				  connection = DBUtils.getConnection();
		    	// SQL语句
		    	String sql = "SELECT cid,cname,tname,sid FROM course WHERE tname = '"+tName+"'";
		    	// step.4 执行SQL语句
		    	 createStatement =connection.createStatement();
		    	// 执行结果返回到set里   ResultSet为接口 
		    	//createStatement.executeQuery(sql)是ResultSet executeQuery实现类（转型）
		    	rs = createStatement.executeQuery(sql);
		    	//step.6 输出查询结果
		    	//创建容器 List
		       arrayList = new ArrayList<Course>();
		    	while(rs.next()) {
		    		int id = rs.getInt(1);
		    		String cname = rs.getString(2);
		    		String tname = rs.getString(3);
		    		int sid = rs.getInt(4);
		    		Course course = new Course(id, cname, tname, sid);
		    		arrayList.add(course);
		    	}	
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				DBUtils.closeResource(rs, createStatement, connection);
			} 

    	return arrayList;
       } 
    // 多条件查询数据
    public List<Course>queryAllCourses(String tName,String courseName){
    	// step.2 加载驱动  = 程序 = 代码
    	// 反射
    	ResultSet rs=null;
    	Statement createStatement=null;
    	Connection connection =null;
    	ArrayList<Course> arrayList =null;
			try {
				  connection = DBUtils.getConnection();
		    	// SQL语句
		    	String sql = "SELECT cid,cname,tname,sid FROM course WHERE tname = '"+tName+"'AND cname = '"+courseName+"'";
		    	// step.4 执行SQL语句
		    	 createStatement =connection.createStatement();
		    	// 执行结果返回到set里   ResultSet为接口 
		    	//createStatement.executeQuery(sql)是ResultSet executeQuery实现类（转型）
		    	rs = createStatement.executeQuery(sql);
		    	//step.6 输出查询结果
		    	//创建容器 List
		       arrayList = new ArrayList<Course>();
		    	while(rs.next()) {
		    		int id = rs.getInt(1);
		    		String cname = rs.getString(2);
		    		String tname = rs.getString(3);
		    		int sid = rs.getInt(4);
		    		Course course = new Course(id, cname, tname, sid);
		    		arrayList.add(course);
		    	}	
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				DBUtils.closeResource(rs, createStatement, connection);
			} 

    	return arrayList;
       } 
   
    // 传递对象
    public List<Course>queryCoursesByCondition(Course course){
    	
    	
        	// step.2 加载驱动  = 程序 = 代码
        	// 反射
        	ResultSet rs=null;
        	Statement createStatement=null;
        	Connection connection =null;
        	ArrayList<Course> arrayList =null;
        	// SQL语句
	    	//String sql = "SELECT cid,cname,tname,sid FROM course WHERE 1=1";
        	// SELECT cid,cname,tname,sid FROM course WHERE 1=1 AND cid = 1
        	StringBuilder stringBuilder = new StringBuilder("SELECT cid,cname,tname,sid FROM course WHERE 1=1");
        	if(course.getcId()!=null) {
        		stringBuilder.append("AND cid ="+course.getcId());
        	}
    			//try {
    				  connection = DBUtils.getConnection();
    		    	System.out.println("sql:"+stringBuilder.toString());
    		    	// step.4 执行SQL语句
    		    	// createStatement =connection.createStatement();
    		    	// 执行结果返回到set里   ResultSet为接口 
    		    	//createStatement.executeQuery(sql)是ResultSet executeQuery实现类（转型）
    		    	//rs = createStatement.executeQuery(sql);
    		    	//step.6 输出查询结果
    		    	//创建容器 List
//    		       arrayList = new ArrayList<Course>();
//    		    	while(rs.next()) {
//    		    		int id = rs.getInt(1);
//    		    		String cname = rs.getString(2);
//    		    		String tname = rs.getString(3);
//    		    		int sid = rs.getInt(4);
//    		    		Course course = new Course(id, cname, tname, sid);
//    		    		arrayList.add(course);
//    		    	}	
//    			} 
//    			catch (SQLException e) {
//    				// TODO Auto-generated catch block
//    				e.printStackTrace();
//    			}
//    			finally {
//    				DBUtils.closeResource(rs, createStatement, connection);
//    			} 

        	return arrayList;
           } 	
}