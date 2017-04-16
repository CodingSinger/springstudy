package SpringBeanProxy;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
 * 切面类(通知)
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
