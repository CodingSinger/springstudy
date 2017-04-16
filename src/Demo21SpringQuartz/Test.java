package Demo21SpringQuartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  除了其他的包，还要引入context.support包
 *  以及quartz所用的所有包
 */
public class Test {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("Demo21SpringQuartz/applicationContext.xml");
	}
} 