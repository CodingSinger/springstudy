package AspectXmlAop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// spring ��ͳaop���������գ� -->
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
