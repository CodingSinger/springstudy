package Demo18NoTransaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JTest
{
	/*
	 * ģ��û�������������ת��ҵ��
	 */
	@Test
	public void Demo() throws Exception{
		ApplicationContext app = new ClassPathXmlApplicationContext("Demo18NoTransaction/applicationContext.xml");
		AccountServiceImpl service = (AccountServiceImpl) app.getBean("accountServiceImpl");
		service.transfer("aaa", "bbb", 100);
	}
}
