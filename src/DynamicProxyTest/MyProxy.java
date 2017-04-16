package DynamicProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler 
{
	/*
	 * obj Ŀ����
	 * proxy ������
	 * myAspect ������(֪ͨ)
	 */
	private Object obj;
	private MyAspect myAspect = new MyAspect();
	public Object bind(Object obj){
		this.obj = obj;
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable
	{
		myAspect.before();
		method.invoke(obj, args);
		myAspect.after();
		return null;
	}

}
