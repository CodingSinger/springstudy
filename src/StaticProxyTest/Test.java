package StaticProxyTest;
/*
 * �ɳ���Ա�������ض������Զ�����Դ���룬�ٶ�����롣�ڳ�������ǰ���������.class�ļ����Ѿ�������
 * ��̬����
 * �൱��һ����ǿ��(װ����ģʽ)
 */
public class Test
{
	public static void main(String[] args){
		MyTest myTest = new MyTestImpl();
		MyTest myTest2 = new MyStrongTest(myTest);
		myTest2.add();
	}
}
