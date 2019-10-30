package com.neuedu.jdbc;

/**
* @ClassName: Test
* @Description: 测试单例
* @author cps
* @date 2019年9月10日 上午11:32:51
*
*/
public class Test {
    public static void main(String[] args) {
		SingleInstance instance = SingleInstance.getInstance();
		SingleInstance instance2 = SingleInstance.getInstance();
		System.out.println(instance==instance2);
	}
}
