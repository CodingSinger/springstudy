package Demo11PnamespaceDi;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo11
{
	/*
	 * setterע��֮p-�����ռ䣺
	 *  xmlns:p="http://www.springframework.org/schema/p"      ��ǰ׺
	 * 	<bean id="bookServiceID" class="Demo11PnamespaceDi.BookService" p:name="qqq" p:bookDao-ref="bookDaoid">
	 * p:��ͨ������=����
	 * p:�Զ�������-ref=����
	 */
	@Test
	public void demo12_1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo11PnamespaceDi/beans.xml");
		//�������
		BookService bookService = (BookService) applicationContext.getBean("bookServiceID");
		bookService.add();
		System.out.println(bookService.getName());
	}
}
