package Demo12SpringEL;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Demo11PnamespaceDi.BookService;

public class Demo12
{
	/*
	 * <property name="name" value="#{'rose'}"></property>��ͨ�ַ���
		<property name="pi" value="#{T(java.lang.Math).PI}"></property>//���þ�̬�����򷽷�#{T(��������).���������ֶ�}
		<property name="testBean" value="#{MyBeanId2}"></property>  #{beanid}���ö���
		<property name="name" value="#{MyBeanId2.name.toUpperCase()}"></property>���ö�������/����
		����÷���û�з���ֵ����Ҳ��ִ�и÷��������ᱨ�������ֶθ�ֵΪnull
		<property name="name" value="#{MyBeanId2.tName?.toUpperCase()}"></property>
		?.���ʽ:���MyBeanId2.tNameΪNull,�򲻻���ú���ķ������ֶΣ����򱨴��ָ��
	 */
	@Test
	public void Demo12_1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo12SpringEL/beans.xml");
		//�������
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
