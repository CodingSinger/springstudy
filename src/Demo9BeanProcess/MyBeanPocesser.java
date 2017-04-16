package Demo9BeanProcess;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPocesser implements BeanPostProcessor 
{

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException
	{
		// TODO Auto-generated method stub
		System.out.println("bean ��ʼ�������"+System.nanoTime()+"  "+arg1);
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException
	{
		// TODO Auto-generated method stub
		System.out.println("bean��ʼ��ǰ"+System.nanoTime()+"  "+arg1);
		return arg0;
	}

}
