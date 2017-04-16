package DynamicProxyTest;
/*
 * 动态代理
 * JDK的动态代理依靠接口实现，如果有些类并没有实现接口，则不能使用JDK代理，这就要使用cglib动态代理了。
 * 
 * 
 * 
 * 1.目标类：接口+实现类
 * 2.切面类
 */
public class Test
{
	public static void main(String[] args){
		MyTest myTest = new MyTestImpl();
		MyProxy myProxy = new MyProxy();
		MyTest now = (MyTest) myProxy.bind(myTest);
		now.add();
		
		
	}
}
