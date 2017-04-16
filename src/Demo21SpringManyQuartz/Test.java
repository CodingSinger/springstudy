package Demo21SpringManyQuartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  除了其他的包，还要引入context.support�?
 *  以及quartz�?��的所有包
 */
public class Test {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("Demo21SpringManyQuartz/applicationContext.xml");
	}
} 