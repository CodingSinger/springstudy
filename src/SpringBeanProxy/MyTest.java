package SpringBeanProxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest
{
	/*������spring��֮��:
	 * spring aop���ˣ�aopalliance-1.0jar
	 * spring aop ʵ��:sprinf-aop-4.2.0-releasejar
	 * (���Զ�)
	 */
	@Test
	public void Test_1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringBeanProxy/beans.xml");
		UserDao dao = (UserDao) applicationContext.getBean("ProxyDaoid");//�õ����Ǵ�����
		dao.add();
	}
}
