package AspectJAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * �����࣬������е�֪ͨ��aspectjû�нӿڣ����е�֪ͨ����ͨ������ȷ����
 */
public class MyAspect
{
	private long before;
	private long after;
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
	public void Myafter(JoinPoint join){
		//System.out.println("after"+" "+join.getSignature().getName()+" "+join.getSignature()+" "+join.getArgs()+" "+join.getKind());
		//after add void AspectJAop.MyTest.add() [Ljava.lang.Object;@126f1908 method-execution
		after = System.currentTimeMillis();
		System.out.println(after);
		System.out.println("�ܹ���ʱ:"+String.valueOf(after-before));
		System.out.println(System.nanoTime());
	}
	
	public void MyafterReturning(Object obj){
		System.out.println("afterReturning"+" "+obj);
		System.out.println(System.nanoTime());
		/*����Ŀ���෽��ִ�к�ķ���ֵ
		 * �˴��Ľ��ܷ���ֵ���ֶ��������bean�����õ�returning��ͬ���������´���
		 * nested exception is java.lang.IllegalStateException: Returning argument name 'obj' was not bound in advice arguments
		 */
	}
	
	public void MyAtferThrowing(Throwable e){
		System.out.println("���쳣"+e.getMessage());
	}
	
	public Object MyAround(ProceedingJoinPoint  join) throws Throwable{
		System.out.println("ǰ");
		Object obj = join.proceed();
		System.out.println("��");
		return obj;
		
	}
	

}
