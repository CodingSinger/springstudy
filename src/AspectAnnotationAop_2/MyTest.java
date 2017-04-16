package AspectAnnotationAop_2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

// spring 传统aop开发（掌握） -->

@Component("test")
public class MyTest
{
	/*
	
	 */
	@Test
	public void Test_1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("AspectAnnotationAop_2/beans.xml");
		UserDao dao = (UserDao) applicationContext.getBean("userDaoId");
		ServiceS dao2 = (ServiceS) applicationContext.getBean("service");
		MyTest dao3 = (MyTest) applicationContext.getBean("test");
		dao.delete();
		dao2.run();
		new MyTest().add();
		dao3.add();
		/**
		 *    beforedelete
				beforerun
				add
				beforeadd
				
				输出如上:可得aspect只对spring管理的bean有效 new出来的实例调用方法并不执行aspect
		 */
	}
	
	public  void add(){
		System.out.println("add");
	}
}
