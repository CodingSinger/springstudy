package SpringTomcatJdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Demo10BeanConstuctor.MyBean;

public class Jtest
{
	@Test
	public void Test_1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringTomcatJdbc/beans.xml");
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
		System.out.println(userDao.find("007"));
	
	}
}
