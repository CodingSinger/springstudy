package StaticProxyTest;
/*
 * 由程序员创建或特定工具自动生成源代码，再对其编译。在程序运行前，代理类的.class文件就已经存在了
 * 静态代理
 * 相当于一个增强类(装饰者模式)
 */
public class Test
{
	public static void main(String[] args){
		MyTest myTest = new MyTestImpl();
		MyTest myTest2 = new MyStrongTest(myTest);
		myTest2.add();
	}
}
