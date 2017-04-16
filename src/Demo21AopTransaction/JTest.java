package Demo21AopTransaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * 比较常用的方法
 */
public class JTest
{
	@Test
	public void Demo() throws Exception{
		ApplicationContext app = new ClassPathXmlApplicationContext("Demo21AopTransaction/applicationContext.xml");
		AccountService service = (AccountService) app.getBean("accountServiceImpl");
		//service.transfer("aaa", "bbb", 100);
		//service.q();
		service.q();
	}
}
