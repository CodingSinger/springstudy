package AspectXmlAop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * ������(���֪ͨ)  ����Ҫʵ�ֽӿ� ���еĹ�������ͨ��xml����
 */

public class MyAspect 
{

	public void befor(){
		System.out.print("before");
	}
	
	private void MyPointCut(){
	}
	

}
