package com.neuedu.jdbc;

/**
* @ClassName: Test
* @Description: ���Ե���
* @author cps
* @date 2019��9��10�� ����11:32:51
*
*/
public class Test {
    public static void main(String[] args) {
		SingleInstance instance = SingleInstance.getInstance();
		SingleInstance instance2 = SingleInstance.getInstance();
		System.out.println(instance==instance2);
	}
}
