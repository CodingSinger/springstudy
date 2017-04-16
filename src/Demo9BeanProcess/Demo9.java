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
		//bean�ڵ���ģʽ�£�ִֻ��������һ����룬���Կ��������ڼ���spring����ʱ���Ѿ���ʼ����
		
		/*������£�
		 *  ���ڳ�ʼ��
			bean��ʼ��ǰ
			��ʼ��
			bean ��ʼ�������
			
			--------------------------
			�Ⱥ������bean�Ĺ�����,�ٹ�bean�ĺ�������postProcessBeforeInitialization����
			�ٹ�init-methodָ���������ٹ�bean��������postProcessAfterInitialization����
			�ҳ�ʼ������ֻ������޲ι����������û���޲ι���������ᱨ��
		 */
		MyBean userService = (MyBean) applicationContext.getBean("Mybeanid");
		userService.run();
		applicationContext.destroy();
	/*
	 *  �������:
	 *  ���ڳ�ʼ��Demo9BeanProcess.MyBean@3639d41753554066795740
		���ڳ�ʼ��Demo9BeanProcess.MyBeanDao@13d5047e753554068534972
		bean��ʼ��ǰ 753554068706189  MybeanDaoid
		bean ��ʼ������� 753554068816291  MybeanDaoid
		����ע����� 753554090839408
		bean��ʼ��ǰ 753554090939245  Mybeanid
		��ʼ�� 753554091078738
		bean ��ʼ������� 753554091144053  Mybeanid
		run 753554098666884
		���� 18, 2016 2:47:12 ���� org.springframework.context.support.AbstractApplicationContext doClose
		��Ϣ: Closing org.springframework.context.support.ClassPathXmlApplicationContext@13c058d6: startup date [Sat Jun 18 14:47:11 CST 2016]; root of context hierarchy
		����753554100309544
	 */
		
		
		/*
		 * ���Beanʵ����InitializingBean����ôbean�ȹ�bean���������ٹ�afterPropertiesSet����
		 * ���Beanʵ����BeanNameAware����ôbean�ȹ�setBeanName����,���beanʵ����BeanFactoryAware����ִ��setBeanFactory������setBeanName()����֮��
		 * ���beanʵ����ApplicationContextAware����ִ��setApplicationContext��setBeanFactory֮��
		 *
		 */
	}

	
}
