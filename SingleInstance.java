package com.neuedu.jdbc;

/**
* @ClassName: SingleInstance
* @Description: �������ģʽ
* @author cps
* @date 2019��9��10�� ����11:27:31
*
*/
public class SingleInstance {
    private SingleInstance() {
    	
    }
    // ������Ա����
//    //����ʽ����
//    private static SingleInstance instance = new SingleInstance();
//    //�ṩ���л�ȡʵ���ķ���
//    public static SingleInstance getInstance() {
//    	return instance;
//    }
    //����ʽ����
    //������Ա����
    private static SingleInstance instance ;
    //�ṩ���л�ȡʵ���ķ���
    public static SingleInstance getInstance() {
    	if(null!=instance) {
    	instance = new SingleInstance();
    	}
    	return instance;
    }
}

