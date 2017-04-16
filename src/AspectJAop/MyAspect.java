package AspectJAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 切面类，存放所有的通知，aspectj没有接口，所有的通知都是通过配置确定的
 */
public class MyAspect
{
	private long before;
	private long after;
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
	public void Myafter(JoinPoint join){
		//System.out.println("after"+" "+join.getSignature().getName()+" "+join.getSignature()+" "+join.getArgs()+" "+join.getKind());
		//after add void AspectJAop.MyTest.add() [Ljava.lang.Object;@126f1908 method-execution
		after = System.currentTimeMillis();
		System.out.println(after);
		System.out.println("总共花时:"+String.valueOf(after-before));
		System.out.println(System.nanoTime());
	}
	
	public void MyafterReturning(Object obj){
		System.out.println("afterReturning"+" "+obj);
		System.out.println(System.nanoTime());
		/*接受目标类方法执行后的返回值
		 * 此处的接受返回值的字段名必须和bean里配置的returning相同，否则报以下错误
		 * nested exception is java.lang.IllegalStateException: Returning argument name 'obj' was not bound in advice arguments
		 */
	}
	
	public void MyAtferThrowing(Throwable e){
		System.out.println("有异常"+e.getMessage());
	}
	
	public Object MyAround(ProceedingJoinPoint  join) throws Throwable{
		System.out.println("前");
		Object obj = join.proceed();
		System.out.println("后");
		return obj;
		
	}
	

}
