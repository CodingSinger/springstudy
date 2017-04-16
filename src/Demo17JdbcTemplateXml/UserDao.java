package Demo17JdbcTemplateXml;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDao extends JdbcDaoSupport
{
	//	private JdbcTemplate jdbcTemplate;
//		public UserDao(JdbcTemplate jdbcTemplate){
//			this.jdbcTemplate = jdbcTemplate;
//		}
//		
		public String find(String id){
			return this.getJdbcTemplate().queryForObject("select bname from book where bid=?", String.class, id);
		}
		
		

}
