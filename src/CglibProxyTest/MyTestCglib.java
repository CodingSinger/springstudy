package CglibProxyTest;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyTestCglib implements MethodInterceptor 
{

	private Object target;
	@Override
	//相当于jdk动态代理的Invoke方法
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
	        //cglib创建目标类的子类,cglib动态创建时，会动态创建目标类的子类，所以目标类不能是final类型
	        //设置父类
	        enhancer.setSuperclass(this.target.getClass());  
	        // 代理类调用回调函数，
	        //设置回调方法  
	        enhancer.setCallback(this);  
	        // 创建代理对象  
	        return enhancer.create();  
	    } 
}
