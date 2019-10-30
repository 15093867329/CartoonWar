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
* @Description: ����JDBC
* @author cps
* @date 2019��9��6�� ����7:55:10
*
*/
public class TestJdbc {
	/*
	 * step.1 ��Ҫ����
       step.2 ��������
       step.3 ��ȡ����
       step.4 ִ��SQL���
       step.5 ���ز�ѯ���
       step.6 �����ѯ���
       step.7 �ر�����
	 */
    public static void main(String[] args) {
    	Course course = new Course(null,null,null,null);
	    List<Course> queryCoursesByCondition = new TestJdbc().queryCoursesByCondition(course);
    	}
    // ��ѯ����
    public List<Course>queryAllCourses(){
    	// step.2 ��������  = ���� = ����
    	// ����
    	ResultSet rs=null;
    	Statement createStatement=null;
    	Connection connection =null;
    	ArrayList<Course> arrayList =null;
			try {
				  connection = DBUtils.getConnection();
		    	// SQL���
		    	String sql = "SELECT cid,cname,tname,sid FROM course";
		    	// step.4 ִ��SQL���
		    	 createStatement =connection.createStatement();
		    	// ִ�н�����ص�set��   ResultSetΪ�ӿ� 
		    	//createStatement.executeQuery(sql)��ResultSet executeQueryʵ���ࣨת�ͣ�
		    	rs = createStatement.executeQuery(sql);
		    	//step.6 �����ѯ���
		    	//�������� List
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
    // ��������ѯ����
    public List<Course>queryAllCourses(String tName){
    	// step.2 ��������  = ���� = ����
    	// ����
    	ResultSet rs=null;
    	Statement createStatement=null;
    	Connection connection =null;
    	ArrayList<Course> arrayList =null;
			try {
				  connection = DBUtils.getConnection();
		    	// SQL���
		    	String sql = "SELECT cid,cname,tname,sid FROM course WHERE tname = '"+tName+"'";
		    	// step.4 ִ��SQL���
		    	 createStatement =connection.createStatement();
		    	// ִ�н�����ص�set��   ResultSetΪ�ӿ� 
		    	//createStatement.executeQuery(sql)��ResultSet executeQueryʵ���ࣨת�ͣ�
		    	rs = createStatement.executeQuery(sql);
		    	//step.6 �����ѯ���
		    	//�������� List
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
    // ��������ѯ����
    public List<Course>queryAllCourses(String tName,String courseName){
    	// step.2 ��������  = ���� = ����
    	// ����
    	ResultSet rs=null;
    	Statement createStatement=null;
    	Connection connection =null;
    	ArrayList<Course> arrayList =null;
			try {
				  connection = DBUtils.getConnection();
		    	// SQL���
		    	String sql = "SELECT cid,cname,tname,sid FROM course WHERE tname = '"+tName+"'AND cname = '"+courseName+"'";
		    	// step.4 ִ��SQL���
		    	 createStatement =connection.createStatement();
		    	// ִ�н�����ص�set��   ResultSetΪ�ӿ� 
		    	//createStatement.executeQuery(sql)��ResultSet executeQueryʵ���ࣨת�ͣ�
		    	rs = createStatement.executeQuery(sql);
		    	//step.6 �����ѯ���
		    	//�������� List
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
   
    // ���ݶ���
    public List<Course>queryCoursesByCondition(Course course){
    	
    	
        	// step.2 ��������  = ���� = ����
        	// ����
        	ResultSet rs=null;
        	Statement createStatement=null;
        	Connection connection =null;
        	ArrayList<Course> arrayList =null;
        	// SQL���
	    	//String sql = "SELECT cid,cname,tname,sid FROM course WHERE 1=1";
        	// SELECT cid,cname,tname,sid FROM course WHERE 1=1 AND cid = 1
        	StringBuilder stringBuilder = new StringBuilder("SELECT cid,cname,tname,sid FROM course WHERE 1=1");
        	if(course.getcId()!=null) {
        		stringBuilder.append("AND cid ="+course.getcId());
        	}
    			//try {
    				  connection = DBUtils.getConnection();
    		    	System.out.println("sql:"+stringBuilder.toString());
    		    	// step.4 ִ��SQL���
    		    	// createStatement =connection.createStatement();
    		    	// ִ�н�����ص�set��   ResultSetΪ�ӿ� 
    		    	//createStatement.executeQuery(sql)��ResultSet executeQueryʵ���ࣨת�ͣ�
    		    	//rs = createStatement.executeQuery(sql);
    		    	//step.6 �����ѯ���
    		    	//�������� List
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