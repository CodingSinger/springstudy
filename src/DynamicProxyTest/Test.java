package DynamicProxyTest;
/*
 * ��̬����
 * JDK�Ķ�̬���������ӿ�ʵ�֣������Щ�ಢû��ʵ�ֽӿڣ�����ʹ��JDK�������Ҫʹ��cglib��̬�����ˡ�
 * 
 * 
 * 
 * 1.Ŀ���ࣺ�ӿ�+ʵ����
 * 2.������
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
