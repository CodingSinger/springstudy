package AspectXmlAop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面类(存放通知)  不需要实现接口 所有的工作都是通过xml配置
 */

public class MyAspect 
{

	public void befor(){
		System.out.print("before");
	}
	
	private void MyPointCut(){
	}
	

}
