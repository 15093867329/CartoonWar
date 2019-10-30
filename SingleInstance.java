package com.neuedu.jdbc;

/**
* @ClassName: SingleInstance
* @Description: 单例设计模式
* @author cps
* @date 2019年9月10日 上午11:27:31
*
*/
public class SingleInstance {
    private SingleInstance() {
    	
    }
    // 创建成员变量
//    //饿汉式单例
//    private static SingleInstance instance = new SingleInstance();
//    //提供公有获取实例的方法
//    public static SingleInstance getInstance() {
//    	return instance;
//    }
    //懒汉式单例
    //创建成员变量
    private static SingleInstance instance ;
    //提供公有获取实例的方法
    public static SingleInstance getInstance() {
    	if(null!=instance) {
    	instance = new SingleInstance();
    	}
    	return instance;
    }
}

