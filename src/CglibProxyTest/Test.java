package CglibProxyTest;

public class Test
{
	/*
	 * Cglib��̬���� 
	JDK�Ķ�̬�������ֻ�ܴ���ʵ���˽ӿڵ��࣬������ʵ�ֽӿڵ���Ͳ���ʵ��JDK�Ķ�̬����cglib���������ʵ�ִ���ģ�
	����ԭ���Ƕ�ָ����Ŀ��������һ�����࣬
	���������з���ʵ����ǿ������Ϊ���õ��Ǽ̳У����Բ��ܶ�final���ε�����д���
	 */
	public static void main(String[] args){
		MyTest myTest = new MyTest();
		MyTestCglib my = new MyTestCglib();
		MyTest myProxy =  (MyTest) my.getInstance(myTest);
		myProxy.add();
		
	}
}	
