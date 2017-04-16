package SpringAopProxy;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面类(通知)
 */
@Component("MyAspectId")
@Aspect
public class MyAspect 
{

	@After(value = "execution(* SpringAopProxy.*.*(..))")
	public void befor(){
		System.out.print("aaaa");
	}
	
	@Pointcut("execution(* SpringAopProxy.*.*(..))")//相当于<aop:pointcut id="MyPointCut" expression="execution(* AspectJAop.*.*(..))" />
	private void MyPointCut(){
		System.out.print("qqq");
	}
	

}
