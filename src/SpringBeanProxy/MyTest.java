package SpringBeanProxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest
{
	/*基础的spring包之外:
	 * spring aop联盟：aopalliance-1.0jar
	 * spring aop 实现:sprinf-aop-4.2.0-releasejar
	 * (半自动)
	 */
	@Test
	public void Test_1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringBeanProxy/beans.xml");
		UserDao dao = (UserDao) applicationContext.getBean("ProxyDaoid");//得到的是代理类
		dao.add();
	}
}
