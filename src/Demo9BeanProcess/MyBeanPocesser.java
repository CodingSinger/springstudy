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
		System.out.println("bean 初始化处理后"+System.nanoTime()+"  "+arg1);
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException
	{
		// TODO Auto-generated method stub
		System.out.println("bean初始化前"+System.nanoTime()+"  "+arg1);
		return arg0;
	}

}
