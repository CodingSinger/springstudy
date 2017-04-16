package Demo7beanScope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.zzc.UserService;

public class Demo7
{

	/*
	 * 
		<bean id="bookServiceID"  class="Demo7beanScope.BookService" scope="prototype"></bean>
		scopeĬ����singleton��������
	 */
	public static void main(String[] args){
	
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo7beanScope/beans.xml");
		BookService userService = (BookService) applicationContext.getBean("bookServiceID");
		BookService userService2 = (BookService) applicationContext.getBean("bookServiceID");
		userService.add();
	}

	
}
