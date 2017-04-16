package AspectJAop;

import org.springframework.aop.framework.AopContext;

public class MyTestImpl	implements MyTest
{

	@Override
	public String add()throws Exception
	{
		System.out.println("add");
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "haha";
	}
	@Override
	public void delete() throws Exception{
		System.out.println("delete");
		throw new Exception();
	}
	@Override
	public void test(int i) throws Exception{//抛出异常不处理，则交给java虚拟机处理，会报错
	//	MyTest service = (MyTestImpl) AopContext.currentProxy(); //获取代理对象
		add();
	}
}
