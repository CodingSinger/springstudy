package AspectJAop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class JTest
{
	@Test
	public void test_1() throws Exception{
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("AspectJAop/beans.xml");
		MyTest dao =  (MyTest) applicationContext.getBean("userServiceId");//得到的是代理类
	//	System.out.println(applicationContext.getBean("userServiceId"));
	//	dao.add();
	//	String s = dao.add();
	//	dao.delete();
		dao.test(0);
	
	}
}
