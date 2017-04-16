package Demo19TransactionAccount;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JTest
{
	/*
	 * �ֶ���ʽ�����������ת��ҵ�����������ݿ�֮�⣬�������������
	 * <!-- ������������� -->
		<bean id="TxManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSourceId"></property>
		</bean>
		<!-- ��������ģ�壬����ģ����Ҫע�����������������ģ��ֻ���������������ʹ�� -->
		<bean id="transicationTemplate" class="org.springframework.transaction.support.TransactionTemplate">
		<property name="transactionManager" ref="TxManager"></property>
		</bean>
	 */
	@Test
	public void Demo() throws Exception{
		ApplicationContext app = new ClassPathXmlApplicationContext("Demo19TransactionAccount/applicationContext.xml");
		AccountServiceImpl service = (AccountServiceImpl) app.getBean("accountServiceImpl");
		service.transfer("aaa", "bbb", 100);
	}
}
