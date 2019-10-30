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
* @Description: TODO(������һ�仰��������������)
* @author cps
* @date 2019��9��8�� ����10:16:14
*
*/
public class LoginFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextField txtname=new JTextField();
    JPasswordField txtpass=new JPasswordField();
    JButton bl=new JButton("��¼");
    JButton bg=new JButton("�ر�");
    //�����޲ι���������Ҫ�ķ������ڹ�������,Ȼ����main���������
    public LoginFrame(){
        setBounds(25,25,250,250);
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,2,10,10));
        c.add(new JLabel("�û���"));
        c.add(txtname);
        c.add(new JLabel("����"));
        c.add(txtpass);
        c.add(bl);
        c.add(bg);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //ע�⣺�˴��������ڲ���
        bg.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        }
        );
        //ע�⣺�˴��������ڲ���
        bl.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String name = txtname.getText();
                String pass = txtpass.getText();
                // ��Ҫ�����û��� �ֶ��Լ���д
                // ����û���Ϊ�� �������û���
                if(name.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
                   }
                else if(pass.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
                   }else {
                	  boolean queryUserByNameAndPsw = queryUserByNameAndPaw(name, pass);
                	  if(queryUserByNameAndPsw==false) {
                		  JOptionPane.showMessageDialog(null, "�û�������������");
                	  }else {
                		  JOptionPane.showMessageDialog(null, "��¼�ɹ�");
                	  }
                   }
                // �������Ϊ�� �������������벻��Ϊ��
      
                // ����û��������벻Ϊ����Ҫȥ���ݿ��ѯ��Ӧ���û� ���û�в鵽��ʾ�û������������
                
                // ���򵯳���¼�ɹ�
              
                //JOptionPane.showMessageDialog(null, "��½�ɹ�");
               
            }
        }
        );
    }
    public static void main(String[] args) {
       new LoginFrame();
//    	 boolean queryUserByNameAndPaw = new LoginFrame().queryUserByNameAndPaw("Tom","123456" );
//          System.out.println(queryUserByNameAndPaw);
    } 
        
        
        
        // �����û����������ѯ�û�
        private boolean queryUserByNameAndPaw(String name,String psw)  {
        	// ��ȡ����
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
