package AspectAopAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面类，存放所有的通知，aspectj没有接口，所有的通知都是通过配置确定的
 */
@Component("myAspectId")//<bean id="myAspectId" class="AspectAopAnnotation.MyAspect"></bean>
@Aspect//<aop:aspect ref="myAspectId">
public class MyAspect
{
	private long before;
	private long after;
	@Before(value = "execution(* AspectAopAnnotation.*.*(..))")//相当于<aop:before method="Mybefore" pointcut="execution(* AspectAopAnnotation.*.*(..))"/>这个pointcut是私有的
	public void Mybefore(JoinPoint join){
	//	System.out.println("before"+join.getSignature().getName());
		/*
		 * JoinPoint
		 * join.getSignature()获得方法签名
		 * join.getSignature().getName()获得方法名
		 * join.getArgs()获得实际参数
		 * join.getKind()获得当前指定方法的类型
		 * 
		 */
		
		before = System.currentTimeMillis();
		System.out.println(before);
	}
	@After(value = "execution(* AspectAopAnnotation.*.*(..))")
	public void Myafter(JoinPoint join){
		//System.out.println("after"+" "+join.getSignature().getName()+" "+join.getSignature()+" "+join.getArgs()+" "+join.getKind());
		//after add void AspectJAop.MyTest.add() [Ljava.lang.Object;@126f1908 method-execution
		after = System.currentTimeMillis();
		System.out.println(after);
		System.out.println("总共花时:"+String.valueOf(after-before));
		System.out.println(System.nanoTime());
	}
	@AfterReturning(value="execution(* AspectAopAnnotation.*.*(..))",returning="obj")
	public void MyafterReturning(Object obj){
		System.out.println("afterReturning"+" "+obj);
		System.out.println(System.nanoTime());
		/*接受目标类方法执行后的返回值
		 * 此处的接受返回值的字段名必须和bean里配置的returning相同，否则报以下错误
		 * nested exception is java.lang.IllegalStateException: Returning argument name 'obj' was not bound in advice arguments
		 */
	}
	@AfterThrowing(value="execution(* AspectAopAnnotation.*.*(..))",throwing="e")
	public void MyAtferThrowing(Throwable e){
		System.out.println("有异常"+e.getMessage());
	}
	@Around(value = "MyPointCut()")//<aop:around method="MyAround" pointcut-ref="MyPointCut" />
	public Object MyAround(ProceedingJoinPoint  join) throws Throwable{
		System.out.println("前");
		Object obj = join.proceed();
		System.out.println("后");
		return obj;
		
	}
	//编写共有的切入点表达式
	@Pointcut("execution(* AspectAopAnnotation.*.*(..))")//相当于<aop:pointcut id="MyPointCut" expression="execution(* AspectJAop.*.*(..))" />
	private void MyPointCut(){
		System.out.print("--------------------");
	}
	

}
