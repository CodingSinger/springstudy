package JdbcQueryTest;

import org.junit.Test;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/*
 * 转账dao
 */
public class AccountDao extends JdbcDaoSupport implements AccountDaoI 
{
	/* (non-Javadoc)
	 * @see Demo18NoTransaction.AccountDaoI#in(java.lang.String, int)
	 */
	@Override
	public void in(String inUser,int money){
		
		this.getJdbcTemplate().update("update account set money =money+? where user=?",money,inUser);
	}
	
	/* (non-Javadoc)
	 * @see Demo18NoTransaction.AccountDaoI#out(java.lang.String, int)
	 */
	@Override
	
	public void out(String outUser,int money){
		this.getJdbcTemplate().update("update account set money =money-? where user=?",money,outUser);

	}
	
	public static void main(String[] args){
		/*
		 * 
	
		queryForObject(String sql, Class<T> requiredType, Object... args) 
		. 
		Object queryForObject(String sql, Object[] args, Class requiredType) 
		2. 
		Object queryForObject(String sql, Object[] args, RowMapper rowMapper) 
		第1个方法是只查一列的，参数“requiredType”不可以是自定义的类 
		如果要把查询结果封装为自定义的类，需要采用第2个方法 
		 */
		
	}
}
