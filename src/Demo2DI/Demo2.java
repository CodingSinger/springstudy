package Demo2DI;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2
{
	@Test
	public void demo2_1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo2DI/beans.xml");
		//»ñµÃÈÝÆ÷
		BookService bookService = (BookService) applicationContext.getBean("bookServiceID");
		bookService.add();
	}
}
