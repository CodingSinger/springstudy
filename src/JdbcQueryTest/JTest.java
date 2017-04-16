package JdbcQueryTest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
		ApplicationContext app = new ClassPathXmlApplicationContext("JdbcQueryTest/applicationContext.xml");
		AccountService service = (AccountService) app.getBean("ProxyService");
		service.transfer("aaa", "bbb", 100);
	}
	
	@Test
	public void Demo2() throws Exception{
		/*
		 * 
	
		queryForObject(String sql, Class<T> requiredType, Object... args) 
		. 
		Object queryForObject(String sql, Object[] args, Class requiredType) ͬ�������ͬ
		2. 
		Object queryForObject(String sql, Object[] args, RowMapper rowMapper) 
		��1��������ֻ��һ�еģ�������requiredType�����������Զ������ 
		���Ҫ�Ѳ�ѯ�����װΪ�Զ�����࣬��Ҫ���õ�2������ 
		 */
		ApplicationContext app = new ClassPathXmlApplicationContext("JdbcQueryTest/applicationContext.xml");
		AccountDao dao = (AccountDao) app.getBean("accountDao");
		System.out.println(dao.getJdbcTemplate().queryForObject("select user from account where id =?",String.class,1));
		System.out.println(dao.getJdbcTemplate().queryForObject("select user from account where id =?",new Object[]{1},String.class));
	}
	

	@Test
	public void Demo3() throws Exception{
		/*
		 * 
	
		Object queryForObject(String sql, Object[] args, RowMapper rowMapper) ʹ��
		
		BeanPropertyRowMapper(Class)����ѯ����һ������ת��Ϊ�Զ�����
		 */
		ApplicationContext app = new ClassPathXmlApplicationContext("JdbcQueryTest/applicationContext.xml");
		AccountDao dao = (AccountDao) app.getBean("accountDao");
		System.out.println(dao.getJdbcTemplate().queryForObject("select * from account where id =?",new BeanPropertyRowMapper(User.class),1));
	}
	
	
	
	
	
	
	
	/*
	 * jdbcTemplate.queryForList(???) ���� a List of Maps, using column name as key. ÿһ��map����һ����¼ 
	 */
	@Test
	public void Demo4() throws Exception{
		/*
		 * 
		public <T> List<T> queryForList(String sql,
                                Class<T> elementType)
                     throws DataAccessException	
 		sql - SQL query to execute
		elementType - the required type of element in the result list (for example, Integer.class)

 

		���� a List of Maps, using column name as key. ÿһ��map����һ����¼ 
	
	
		 */
		ApplicationContext app = new ClassPathXmlApplicationContext("JdbcQueryTest/applicationContext.xml");
		AccountDao dao = (AccountDao) app.getBean("accountDao");
		List list = dao.getJdbcTemplate().queryForList("select user from account",String.class);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		
		//����ѯ�Ľ����װ��list����
	}
	
	@Test
	public void Demo5() throws Exception{
		/*
		 * 
		public <T> List<T> queryForList(String sql)
                     throws DataAccessException	
 		sql - SQL query to execute
	

 

		���� a List of Maps, using column name as key. ÿһ��map����һ����¼ 
	
	
		 */
		ApplicationContext app = new ClassPathXmlApplicationContext("JdbcQueryTest/applicationContext.xml");
		AccountDao dao = (AccountDao) app.getBean("accountDao");
		List list = dao.getJdbcTemplate().queryForList("select * from account");
		for(int i=0;i<list.size();i++){
			Map map =(Map) list.get(i);
			System.out.println(map);
		}
		
		
		
	}
	
	
	@Test
	public void Demo6() throws Exception{
		/*
		 * 
		public List<Map<String,Object>> queryForList(String sql,
                                             Object... args)
                                      throws DataAccessException
	sql - SQL query to execute
	args - arguments to bind to the query (leaving it to the PreparedStatement to guess the corresponding SQL type);
	 may also contain SqlParameterValue objects which indicate not only the argument value but also the SQL type and optionally the scale
 

		
	����һ��list����List����Ԫ��Ϊmap��ÿ��map��һ����ѯ��¼�����ֶ���Ϊ����
	
		 */
		ApplicationContext app = new ClassPathXmlApplicationContext("JdbcQueryTest/applicationContext.xml");
		AccountDao dao = (AccountDao) app.getBean("accountDao");
		List list = dao.getJdbcTemplate().queryForList("select * from account where user=?","aaa");
		for(int i=0;i<list.size();i++){
			Map map =(Map) list.get(i);
			System.out.println(map.get("id"));
			System.out.println(map);
		}
		
		
		
	}
	
	
	@Test
	public void Demo7 (){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("JdbcQueryTest/applicationContext.xml");
		AccountDao dao = (AccountDao) app.getBean("accountDao");
		  final String sql="insert into account(user,money)values(?,?)";
		    KeyHolder keyHolder = new GeneratedKeyHolder();
		    dao.getJdbcTemplate().update(new PreparedStatementCreator() {
		       

				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException
				{ 
					PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
					ps.setString(1, "areaName");
					ps.setString(2, "8888888");
					//ps.execute();
					return ps;
				}
		    }, keyHolder);
		    System.out.println( keyHolder.getKey().intValue());
	}
	
}
