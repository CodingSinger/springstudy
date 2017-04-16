package Demo14_1XmlAndAnnotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo14_1
{
	
	/*
	 * 实际开发中通常使用：xml + 注解
		xml ： <bean id="" class="">
		注解：注入 @Autowired 
		注解，如果混合使用不需要扫描，只需要添加特殊注解
		<!-- 如果配置此项，所有注入的注解就可以使用了 -->
		<context:annotation-config></context:annotation-config>
	 */
	@Test
	public void Demo14_1_1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo14_1XmlAndAnnotation/beans.xml");
		MyBean myBean = (MyBean) applicationContext.getBean("MybeanId");
	
		System.out.println(myBean);
	
	}
}
