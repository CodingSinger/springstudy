package Springsource1;

public class Mybean
{
	@MyValue("sss")
	private String name;
	@MyValue(value="22")
	private int age;
	@Override
	public String toString()
	{
		return "Mybean [name=" + name + ", age=" + age + "]";
	}
	
}
