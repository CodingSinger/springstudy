package Demo10BeanConstuctor;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean 
{
	private String name;
	private String age;
	private MySupport mySupport;
	public String getName()
	{
		return name;
	}
	public String getAge()
	{
		return age;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	
	public MyBean(String name,String age,MySupport mySupport){
		this.name=name;
		this.age= age;
		this.mySupport=mySupport;
	}
	@Override
	public String toString()
	{
		return "MyBean [name=" + name + ", age=" + age + ", mySupport="
				+ mySupport + "]";
	}

}
