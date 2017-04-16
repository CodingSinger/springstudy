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
		Object queryForObject(String sql, Object[] args, Class requiredType) 同上面的相同
		2. 
		Object queryForObject(String sql, Object[] args, RowMapper rowMapper) 
		第1个方法是只查一列的，参数“requiredType”不可以是自定义的类 
		如果要把查询结果封装为自定义的类，需要采用第2个方法 
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
	
		Object queryForObject(String sql, Object[] args, RowMapper rowMapper) 使用
		
		BeanPropertyRowMapper(Class)将查询到的一行数据转化为自定义类
		 */
		ApplicationContext app = new ClassPathXmlApplicationContext("JdbcQueryTest/applicationContext.xml");
		AccountDao dao = (AccountDao) app.getBean("accountDao");
		System.out.println(dao.getJdbcTemplate().queryForObject("select * from account where id =?",new BeanPropertyRowMapper(User.class),1));
	}
	
	
	
	
	
	
	
	/*
	 * jdbcTemplate.queryForList(???) 返回 a List of Maps, using column name as key. 每一个map代表一条记录 
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

 

		返回 a List of Maps, using column name as key. 每一个map代表一条记录 
	
	
		 */
		ApplicationContext app = new ClassPathXmlApplicationContext("JdbcQueryTest/applicationContext.xml");
		AccountDao dao = (AccountDao) app.getBean("accountDao");
		List list = dao.getJdbcTemplate().queryForList("select user from account",String.class);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		
		//将查询的结果封装成list返回
	}
	
	@Test
	public void Demo5() throws Exception{
		/*
		 * 
		public <T> List<T> queryForList(String sql)
                     throws DataAccessException	
 		sql - SQL query to execute
	

 

		返回 a List of Maps, using column name as key. 每一个map代表一条记录 
	
	
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
 

		
	返回一组list，该List的子元素为map，每个map是一条查询记录，以字段名为键，
	
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
