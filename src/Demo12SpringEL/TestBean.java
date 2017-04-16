package Demo12SpringEL;


public class TestBean
{
	private String name="jack";
	private double pi;
	private String tName;
	public String gettName()
	{
		return tName;
	}
	public void settName(String tName)
	{
		this.tName = tName;
	}
	public String getName()
	{
		return name;
	}
	public double getPi()
	{
		return pi;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setPi(double pi)
	{
		this.pi = pi;
	}
	@Override
	public String toString()
	{
		return "TestBean [name=" + name + ", pi=" + pi + "]";
	}
	public String to(){
		return "hello";
	}
	
	
}
