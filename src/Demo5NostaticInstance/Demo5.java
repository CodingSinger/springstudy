package Demo5NostaticInstance;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.zzc.UserService;
import Demo4Instance.BookService;
public class Demo5
{

	/*
	 * 实例工厂
	 * 以及FileSystemXmlApplicationContext和ClassPathXmlApplicationContext的使用
	 */
	@Test
	public  void demo5_1(){
	//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo5NostaticInstance/beans.xml");
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:/myeclipse/workspace/TestSpring/src/Demo4Instance/beans.xml");
		Demo4Instance.BookService userService = (Demo4Instance.BookService) applicationContext.getBean("bookServiceID");
		userService.add();
	}
	/*
	 * FileSystemXmlApplicationContext从任意路径寻找资源文件
	 */
	@Test
	public  void demo5_2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo4Instance/beans.xml");
		Demo4Instance.BookService userService = (Demo4Instance.BookService) applicationContext.getBean("bookServiceID");
		userService.add();
	}
	
	/*
	 * ClassPathXmlApplicationContext,根目录为classpath(即src),/表示src
	 * 
	 */
	
	@Test
	public  void demo5_3(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		//若beans.xml放到src下，则/bean.xml和beans.xml都可行
		Demo5NostaticInstance.BookService userService = (Demo5NostaticInstance.BookService) applicationContext.getBean("bookServiceID");
		userService.add();
	}
	
}
