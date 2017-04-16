package Demo8BeanInitDestory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Demo8
{

	/*
	 * 使用销毁方法
	 * 必须是单例的，且关闭容器	<!-- init-method="init" destroy-method="destroy" 如果配置了该参数，但没有该方法会报错 -->
		仅仅在默认情况即singleton模式下，destroy-method才会起作用。而多例情况下init-method方法会在每次使用bean时执行一次
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
