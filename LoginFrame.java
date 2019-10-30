package com.neuedu.jdbc;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.neuedu.utils.DBUtils;
/**
* @ClassName: LoginFrame
* @Description: TODO(这里用一句话描述这个类的作用)
* @author cps
* @date 2019年9月8日 上午10:16:14
*
*/
public class LoginFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextField txtname=new JTextField();
    JPasswordField txtpass=new JPasswordField();
    JButton bl=new JButton("登录");
    JButton bg=new JButton("关闭");
    //构造无参构造器把主要的方法放在构造器里,然后在main方法里面调
    public LoginFrame(){
        setBounds(25,25,250,250);
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,2,10,10));
        c.add(new JLabel("用户名"));
        c.add(txtname);
        c.add(new JLabel("密码"));
        c.add(txtpass);
        c.add(bl);
        c.add(bg);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //注意：此处是匿名内部类
        bg.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        }
        );
        //注意：此处是匿名内部类
        bl.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String name = txtname.getText();
                String pass = txtpass.getText();
                // 需要创建用户表 字段自己编写
                // 如果用户名为空 请输入用户名
                if(name.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "用户名不能为空");
                   }
                else if(pass.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "密码不能为空");
                   }else {
                	  boolean queryUserByNameAndPsw = queryUserByNameAndPaw(name, pass);
                	  if(queryUserByNameAndPsw==false) {
                		  JOptionPane.showMessageDialog(null, "用户名或密码有误");
                	  }else {
                		  JOptionPane.showMessageDialog(null, "登录成功");
                	  }
                   }
                // 如果密码为空 请输入密码密码不能为空
      
                // 如果用户名和密码不为空需要去数据库查询对应的用户 如果没有查到提示用户名或密码错误
                
                // 否则弹出登录成功
              
                //JOptionPane.showMessageDialog(null, "登陆成功");
               
            }
        }
        );
    }
    public static void main(String[] args) {
       new LoginFrame();
//    	 boolean queryUserByNameAndPaw = new LoginFrame().queryUserByNameAndPaw("Tom","123456" );
//          System.out.println(queryUserByNameAndPaw);
    } 
        
        
        
        // 根据用户名和密码查询用户
        private boolean queryUserByNameAndPaw(String name,String psw)  {
        	// 获取连接
        	Connection connection = DBUtils.getConnection();
        	Statement createStatement =null;
        	ResultSet executeQuery = null;
        	try {
				createStatement = connection.createStatement();
		        executeQuery = createStatement.executeQuery("SELECT user_name,user_psw FROM user WHERE user_name ='"+name+"' AND user_psw = '"+psw+"'");
				if(executeQuery.next()) {
	        		return true;
	        	}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.closeResource(executeQuery, createStatement, connection);
			}
        	return false;
        }
}
