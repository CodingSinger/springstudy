package Demo16JdbcTemplate;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJ
{
	public static void main(String[] args){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/estore");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		
				//2 创建模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				// 2.1 设置数据�?
		//jdbcTemplate.setDataSource(dataSource);
				
				//3 录入数据
		String res = jdbcTemplate.queryForObject("select bname from book where bid=?", String.class, "004");
		System.out.println(res);
		
	}
}
