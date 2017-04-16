package Demo9BeanProcess;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Demo9
{

	/*
	 
	 * 
	 */
	@Test
	public void Demo8_1(){
	
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo9BeanProcess/beans.xml");
		//bean在单例模式下，只执行上面这一句代码，可以看到单例在加载spring容器时就已经初始化了
		
		/*输出如下：
		 *  正在初始化
			bean初始化前
			初始化
			bean 初始化处理后
			
			--------------------------
			先后调用了bean的构造器,再过bean的后处理器的postProcessBeforeInitialization方法
			再过init-method指定方法，再过bean后处理器的postProcessAfterInitialization方法
			且初始化过程只会调用无参构造器，如果没有无参构造器，则会报错
		 */
		MyBean userService = (MyBean) applicationContext.getBean("Mybeanid");
		userService.run();
		applicationContext.destroy();
	/*
	 *  输出如下:
	 *  正在初始化Demo9BeanProcess.MyBean@3639d41753554066795740
		正在初始化Demo9BeanProcess.MyBeanDao@13d5047e753554068534972
		bean初始化前 753554068706189  MybeanDaoid
		bean 初始化处理后 753554068816291  MybeanDaoid
		正在注入参数 753554090839408
		bean初始化前 753554090939245  Mybeanid
		初始化 753554091078738
		bean 初始化处理后 753554091144053  Mybeanid
		run 753554098666884
		六月 18, 2016 2:47:12 下午 org.springframework.context.support.AbstractApplicationContext doClose
		信息: Closing org.springframework.context.support.ClassPathXmlApplicationContext@13c058d6: startup date [Sat Jun 18 14:47:11 CST 2016]; root of context hierarchy
		销毁753554100309544
	 */
		
		
		/*
		 * 如果Bean实现了InitializingBean，那么bean先过bean后处理器，再过afterPropertiesSet方法
		 * 如果Bean实现了BeanNameAware，那么bean先过setBeanName方法,如果bean实现了BeanFactoryAware，则执行setBeanFactory方法在setBeanName()方法之后
		 * 如果bean实现了ApplicationContextAware，则执行setApplicationContext在setBeanFactory之后
		 *
		 */
	}

	
}
