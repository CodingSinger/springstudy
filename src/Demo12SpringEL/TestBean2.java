package Demo12SpringEL;

public class TestBean2
{
	private TestBean testBean;
	private String bName;
	public String getbName()
	{
		return bName;
	}

	public void setbName(String bName)
	{
		this.bName = bName;
	}

	public TestBean getTestBean()
	{
		return testBean;
	}

	public void setTestBean(TestBean testBean)
	{
		this.testBean = testBean;
	}

	@Override
	public String toString()
	{
		return "TestBean2 [testBean=" + testBean + ", bName=" + bName + "]";
	}

	
}
