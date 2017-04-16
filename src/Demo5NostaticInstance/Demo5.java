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
	 * ʵ������
	 * �Լ�FileSystemXmlApplicationContext��ClassPathXmlApplicationContext��ʹ��
	 */
	@Test
	public  void demo5_1(){
	//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo5NostaticInstance/beans.xml");
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:/myeclipse/workspace/TestSpring/src/Demo4Instance/beans.xml");
		Demo4Instance.BookService userService = (Demo4Instance.BookService) applicationContext.getBean("bookServiceID");
		userService.add();
	}
	/*
	 * FileSystemXmlApplicationContext������·��Ѱ����Դ�ļ�
	 */
	@Test
	public  void demo5_2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo4Instance/beans.xml");
		Demo4Instance.BookService userService = (Demo4Instance.BookService) applicationContext.getBean("bookServiceID");
		userService.add();
	}
	
	/*
	 * ClassPathXmlApplicationContext,��Ŀ¼Ϊclasspath(��src),/��ʾsrc
	 * 
	 */
	
	@Test
	public  void demo5_3(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		//��beans.xml�ŵ�src�£���/bean.xml��beans.xml������
		Demo5NostaticInstance.BookService userService = (Demo5NostaticInstance.BookService) applicationContext.getBean("bookServiceID");
		userService.add();
	}
	
}
