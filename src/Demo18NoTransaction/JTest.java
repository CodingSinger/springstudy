package Demo18NoTransaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JTest
{
	/*
	 * 模拟没有事务处理的银行转账业务
	 */
	@Test
	public void Demo() throws Exception{
		ApplicationContext app = new ClassPathXmlApplicationContext("Demo18NoTransaction/applicationContext.xml");
		AccountServiceImpl service = (AccountServiceImpl) app.getBean("accountServiceImpl");
		service.transfer("aaa", "bbb", 100);
	}
}
