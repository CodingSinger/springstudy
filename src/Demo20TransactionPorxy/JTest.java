package Demo20TransactionPorxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JTest
{
	/*
	 * 手动方式事务处理的银行转账业务：在配置数据库之外，加上下面的配置
	 * <!-- 设置事务管理器 -->
		<bean id="TxManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSourceId"></property>
		</bean>
		<!-- 设置事务模板，事务模板需要注入事务管理器，事务模板只能在事务管理器上使用 -->
		<bean id="transicationTemplate" class="org.springframework.transaction.support.TransactionTemplate">
		<property name="transactionManager" ref="TxManager"></property>
		</bean>
	 */
	@Test
	public void Demo() throws Exception{
		ApplicationContext app = new ClassPathXmlApplicationContext("Demo21AopTransaction/applicationContext.xml");
		AccountService service = (AccountService) app.getBean("ProxyService");
		service.transfer("aaa", "bbb", 100);
	}
}
