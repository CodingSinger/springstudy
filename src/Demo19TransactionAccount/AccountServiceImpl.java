package Demo19TransactionAccount;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



public class AccountServiceImpl implements AccountService
{
	
	
	private AccountDao accountDao;
	private TransactionTemplate transactionTemplate;//ע��ģ��
	public void setTransactionTemplate(TransactionTemplate transactionTemplate)
	{
		this.transactionTemplate = transactionTemplate;
	}
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
	public void transfer(final String inUser,final String outUser,final int money) throws Exception{
	//TransactionCallbackWithoutResult����û�н������
		this.transactionTemplate.execute(new TransactionCallbackWithoutResult()
		{
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status)
			{
				// TODO Auto-generated method stub
				accountDao.out(outUser, money);
				int i=1/0;//ģ��ͻ���ϵ�
				System.out.println("ds");
				accountDao.in(inUser, money);
			}
		});
//		accountDao.out(outUser, money);
//		int i=1/0;//ģ��ͻ���ϵ�
//		accountDao.in(inUser, money);
	}
}
