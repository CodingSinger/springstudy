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
 * �����࣬������е�֪ͨ��aspectjû�нӿڣ����е�֪ͨ����ͨ������ȷ����
 */
@Component("myAspectId")//<bean id="myAspectId" class="AspectAopAnnotation.MyAspect"></bean>
@Aspect//<aop:aspect ref="myAspectId">
public class MyAspect
{
	private long before;
	private long after;
	@Before(value = "execution(* AspectAopAnnotation.*.*(..))")//�൱��<aop:before method="Mybefore" pointcut="execution(* AspectAopAnnotation.*.*(..))"/>���pointcut��˽�е�
	public void Mybefore(JoinPoint join){
	//	System.out.println("before"+join.getSignature().getName());
		/*
		 * JoinPoint
		 * join.getSignature()��÷���ǩ��
		 * join.getSignature().getName()��÷�����
		 * join.getArgs()���ʵ�ʲ���
		 * join.getKind()��õ�ǰָ������������
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
		System.out.println("�ܹ���ʱ:"+String.valueOf(after-before));
		System.out.println(System.nanoTime());
	}
	@AfterReturning(value="execution(* AspectAopAnnotation.*.*(..))",returning="obj")
	public void MyafterReturning(Object obj){
		System.out.println("afterReturning"+" "+obj);
		System.out.println(System.nanoTime());
		/*����Ŀ���෽��ִ�к�ķ���ֵ
		 * �˴��Ľ��ܷ���ֵ���ֶ��������bean�����õ�returning��ͬ���������´���
		 * nested exception is java.lang.IllegalStateException: Returning argument name 'obj' was not bound in advice arguments
		 */
	}
	@AfterThrowing(value="execution(* AspectAopAnnotation.*.*(..))",throwing="e")
	public void MyAtferThrowing(Throwable e){
		System.out.println("���쳣"+e.getMessage());
	}
	@Around(value = "MyPointCut()")//<aop:around method="MyAround" pointcut-ref="MyPointCut" />
	public Object MyAround(ProceedingJoinPoint  join) throws Throwable{
		System.out.println("ǰ");
		Object obj = join.proceed();
		System.out.println("��");
		return obj;
		
	}
	//��д���е��������ʽ
	@Pointcut("execution(* AspectAopAnnotation.*.*(..))")//�൱��<aop:pointcut id="MyPointCut" expression="execution(* AspectJAop.*.*(..))" />
	private void MyPointCut(){
		System.out.print("--------------------");
	}
	

}
