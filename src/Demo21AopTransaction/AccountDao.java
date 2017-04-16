package Demo21AopTransaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/*
 * ×ªÕËdao
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
}
