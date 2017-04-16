package Demo4Instance;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzc.UserService;

public class Demo4
{
	/*
	 * 静态工厂实例化
	 */
	@Test
	public void Demo4_1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo4Instance/beans.xml");
		BookService userService = (BookService) applicationContext.getBean("bookServiceID");
		BookService userService2 = (BookService) applicationContext.getBean("bookServiceID");
		userService.add();
	}
}
