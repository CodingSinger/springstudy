package SpringBeanProxy;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
 * ������(֪ͨ)
 */

public class MyAspect implements MethodInterceptor
{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable
	{
		System.out.println("before");
		arg0.proceed();
		System.out.println("after");
		return null;
	}

	

}
