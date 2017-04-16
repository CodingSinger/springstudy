package Demo11PnamespaceDi;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo11
{
	/*
	 * setter注入之p-命名空间：
	 *  xmlns:p="http://www.springframework.org/schema/p"      加前缀
	 * 	<bean id="bookServiceID" class="Demo11PnamespaceDi.BookService" p:name="qqq" p:bookDao-ref="bookDaoid">
	 * p:普通属性名=“”
	 * p:自定义类名-ref=“”
	 */
	@Test
	public void demo12_1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo11PnamespaceDi/beans.xml");
		//获得容器
		BookService bookService = (BookService) applicationContext.getBean("bookServiceID");
		bookService.add();
		System.out.println(bookService.getName());
	}
}
