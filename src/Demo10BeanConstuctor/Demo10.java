package Demo10BeanConstuctor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Demo10
{

	/*
	 
	 * 	<constructor-arg index="0" value="qqq"></constructor-arg>
		<constructor-arg index="1" value="10"></constructor-arg>
		<constructor-arg index="2" ref="MySupportId">
		配置调用Bean的指定构造器
		type表示数据类型
		
		--------------------------------------------------------------
		对比参数注入<property ref="bookDaoid" name="bookDao"></property>
	 */
	@Test
	public void Demo10_1(){
	
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo10BeanConstuctor/beans.xml");
	
		MyBean userService = (MyBean) applicationContext.getBean("Mybeanid");
		
		System.out.println(userService);
	
	}

	
}
