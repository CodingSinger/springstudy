package Demo8BeanInitDestory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Demo8
{

	/*
	 * ʹ�����ٷ���
	 * �����ǵ����ģ��ҹر�����	<!-- init-method="init" destroy-method="destroy" ��������˸ò�������û�и÷����ᱨ�� -->
		������Ĭ�������singletonģʽ�£�destroy-method�Ż������á������������init-method��������ÿ��ʹ��beanʱִ��һ��
	 */
	@Test
	public void Demo8_1(){
	
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo8BeanInitDestory/beans.xml");
		BookService userService = (BookService) applicationContext.getBean("bookServiceID");
		BookService userService2 = (BookService) applicationContext.getBean("bookServiceID");
		userService.add();
		applicationContext.destroy();
	
	}

	
}
