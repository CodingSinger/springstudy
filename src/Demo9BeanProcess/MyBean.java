package Demo9BeanProcess;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements InitializingBean,BeanNameAware,BeanFactoryAware,ApplicationContextAware 
{
	private MyBeanDao myBeanDao;
	public MyBeanDao getMyBeanDao()
	{
		return myBeanDao;
	}

	public void setMyBeanDao(MyBeanDao myBeanDao)
	{
		System.out.println("正在注入参数"+System.nanoTime());
		this.myBeanDao = myBeanDao;
	}

	public MyBean(){
		System.out.println("正在初始化"+this+System.nanoTime());
	}

	public void init(){
		System.out.println("初始化init"+System.nanoTime());
		
	}
	public void destroy(){
		System.out.println("销毁"+System.nanoTime());
	}
	
	public void run(){
		System.out.println("run"+System.nanoTime());
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet()"+System.nanoTime());
	}

	@Override
	public void setBeanName(String name)
	{
		// TODO Auto-generated method stub
		System.out.println("setBeanName"+name+System.nanoTime());
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException
	{
		// TODO Auto-generated method stub
		System.out.println("setBeanFactory"+beanFactory+System.nanoTime());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException
	{
		System.out.println("setApplicationContext"+applicationContext+System.nanoTime());
		
	}

}
