package Demo10BeanConstuctor;

public class MySupport
{
	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "MySupport [name=" + name + "]";
	}
	public MySupport(String name){
		this.name=name;
	}
}
