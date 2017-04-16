package Demo22AnnotationTransaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JTest
{
	/*
	 * transactional修饰要进行事务管理的类或方法
	 */
	@Test
	public void Demo() throws Exception{
		ApplicationContext app = new ClassPathXmlApplicationContext("Demo22AnnotationTransaction/applicationContext.xml");
		AccountService service = (AccountService) app.getBean("accountServiceImpl");
		service.transfer("aaa", "bbb", 100);
	}
}
