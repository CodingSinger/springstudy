package Demo13DI_Collections;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Demo11PnamespaceDi.BookService;

public class Demo13
{
	
	@Test
	public void Demo13_1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo13DI_Collections/beans.xml");
		MyBean myBean = (MyBean) applicationContext.getBean("MyBeanId");
		System.out.println(myBean);
	}
}
