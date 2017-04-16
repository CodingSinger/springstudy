package CglibProxyTest;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyTestCglib implements MethodInterceptor 
{

	private Object target;
	@Override
	//�൱��jdk��̬�����Invoke����
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable
	{
		// TODO Auto-generated method stub
		System.out.println("before");
		arg1.invoke(target, arg2);
		System.out.println("after");
		return null;
	}
	 public Object getInstance(Object target) {  
	        this.target = target;  
	        Enhancer enhancer = new Enhancer();  
	        //cglib����Ŀ���������,cglib��̬����ʱ���ᶯ̬����Ŀ��������࣬����Ŀ���಻����final����
	        //���ø���
	        enhancer.setSuperclass(this.target.getClass());  
	        // ��������ûص�������
	        //���ûص�����  
	        enhancer.setCallback(this);  
	        // �����������  
	        return enhancer.create();  
	    } 
}
