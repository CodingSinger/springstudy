package StaticProxyTest;

public class MyStrongTest implements MyTest
{
	private MyTest myTest;

	public MyTest getMyTest()
	{
		return myTest;
	}

	public void setMyTest(MyTest myTest)
	{
		this.myTest = myTest;
	}
	public MyStrongTest(MyTest test){
		this.myTest=test;
		
	}

	@Override
	public void add()
	{
		System.out.println("before");
		myTest.add();
		System.out.println("after");	
	}
}
