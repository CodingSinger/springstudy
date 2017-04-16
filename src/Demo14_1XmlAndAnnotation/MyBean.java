package Demo14_1XmlAndAnnotation;

import org.springframework.beans.factory.annotation.Value;

public class MyBean
{
	@Value("2")
	private int age;
	@Value("sss")
	private String name;
	@Override
	public String toString()
	{
		return "MyBean [age=" + age + ", name=" + name + "]";
	}
}
