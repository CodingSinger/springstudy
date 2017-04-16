package Demo18NoTransaction;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService
{
	private AccountDao accountDao;
	/* (non-Javadoc)
	 * @see Demo18NoTransaction.AccountService#setAccountDao(Demo18NoTransaction.AccountDao)
	 */
	@Override
	public void setAccountDao(AccountDao accountDao)
	{
		this.accountDao = accountDao;
	}
	/* (non-Javadoc)
	 * @see Demo18NoTransaction.AccountService#transfer(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void transfer(String inUser,String outUser,int money) throws Exception{
		this.accountDao.out(outUser, money);
		int i=1/0;//Ä£ÄâÍ»·¢¶Ïµç
		this.accountDao.in(inUser, money);
	
	}
}
