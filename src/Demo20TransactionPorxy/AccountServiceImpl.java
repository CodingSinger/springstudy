package Demo20TransactionPorxy;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



public class AccountServiceImpl implements AccountService
{
	
	
	private AccountDao accountDao;
	
	/* (non-Javadoc)
	 * @see Demo18NoTransaction.AccountService#setAccountDao(Demo18NoTransaction.AccountDao)
	 */
	public void setAccountDao(AccountDao accountDao)
	{
		this.accountDao = accountDao;
	}
	/* (non-Javadoc)
	 * @see Demo18NoTransaction.AccountService#transfer(java.lang.String, java.lang.String, int)
	 */
	public void transfer(final String inUser,final String outUser,final int money) throws Exception{
	
		accountDao.out(outUser, money);
		int i=1/0;//Ä£ÄâÍ»·¢¶Ïµç
		accountDao.in(inUser, money);
	}
}
