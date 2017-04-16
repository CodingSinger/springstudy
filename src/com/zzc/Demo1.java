package com.zzc;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Demo1
{

		@Test
		public void demo01(){
			//1 加载配置文件
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/zzc/beans.xml");
			//2 从spring工厂获得对象
			UserService userService = (UserService) applicationContext.getBean("userServiceId");
			userService.Add();
			
		}
	
}
