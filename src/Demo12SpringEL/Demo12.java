package Demo12SpringEL;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Demo11PnamespaceDi.BookService;

public class Demo12
{
	/*
	 * <property name="name" value="#{'rose'}"></property>普通字符串
		<property name="pi" value="#{T(java.lang.Math).PI}"></property>//引用静态变量或方法#{T(完整类名).方法或者字段}
		<property name="testBean" value="#{MyBeanId2}"></property>  #{beanid}引用对象
		<property name="name" value="#{MyBeanId2.name.toUpperCase()}"></property>引用对象属性/方法
		如果该方法没有返回值，则也会执行该方法，不会报错，但该字段赋值为null
		<property name="name" value="#{MyBeanId2.tName?.toUpperCase()}"></property>
		?.表达式:如果MyBeanId2.tName为Null,则不会调用后面的方法和字段，否则报错空指针
	 */
	@Test
	public void Demo12_1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo12SpringEL/beans.xml");
		//获得容器
		TestBean testBean = (TestBean) applicationContext.getBean("MyBeanId");
		TestBean testBean2 = (TestBean) applicationContext.getBean("MyBeanId2");
		TestBean testBean4 = (TestBean) applicationContext.getBean("MyBeanId4");
		TestBean2 testBean3 = (TestBean2) applicationContext.getBean("MyBeanId3");
		System.out.println(testBean);
		System.out.println(testBean2);
		System.out.println(testBean3);
		System.out.println(testBean4);
	}
}
