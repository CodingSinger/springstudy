package com.zzc;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Demo1
{

		@Test
		public void demo01(){
			//1 ���������ļ�
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/zzc/beans.xml");
			//2 ��spring������ö���
			UserService userService = (UserService) applicationContext.getBean("userServiceId");
			userService.Add();
			
		}
	
}
