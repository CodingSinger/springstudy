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
	public void test(int i) throws Exception{//�׳��쳣�������򽻸�java����������ᱨ��
	//	MyTest service = (MyTestImpl) AopContext.currentProxy(); //��ȡ�������
		add();
	}
}
