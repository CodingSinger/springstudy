package Demo14DIannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("MybeanId")
@Scope("prototype")//多例
public class MyBean
{
	@Value("2")//普通类型值注入
	private int age;
	@Value("sss")
	private String name;
	public int getAge()
	{
		return age;
	}
	public String getName()
	{
		return name;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	@PostConstruct
	public void init(){
		System.out.println("init..");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("destroy");
	}
	public String toString()
	{
		return "MyBean [age=" + age + ", name=" + name + "]";
	}
	
}
