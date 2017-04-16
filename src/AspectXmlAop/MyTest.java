package AspectXmlAop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// spring 传统aop开发（掌握） -->
public class MyTest
{
	/*
	
	 */
	@Test
	public void Test_1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("AspectXmlAop/beans.xml");
		UserDao dao = (UserDao) applicationContext.getBean("userDaoId");
		dao.delete();
	}
}
