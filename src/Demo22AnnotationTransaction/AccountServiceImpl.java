package Demo22AnnotationTransaction;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



public class AccountServiceImpl implements AccountService
{
	
	
	private AccountDao accountDao;
	
	@Override
	@Transactional
	public void setAccountDao(AccountDao accountDao)
	{
		this.accountDao = accountDao;
	
	}
	@Override
	@Transactional
	public void transfer(final String inUser,final String outUser,final int money) throws Exception{
	
		accountDao.out(outUser, money);
	//	int i=1/0;//Ä£ÄâÍ»·¢¶Ïµç
		accountDao.in(inUser, money);
	}
}
