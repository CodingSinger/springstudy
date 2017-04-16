package Demo21AopTransaction;

import org.springframework.aop.framework.AopContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



public class AccountServiceImpl implements AccountService
{
	
	
	private AccountDao accountDao;
	
	@Override
	public void setAccountDao(AccountDao accountDao)
	{
		this.accountDao = accountDao;
	
	}
	@Override
	public void transfer(final String inUser,final String outUser,final int money) throws Exception{
	
		accountDao.out(outUser, money);
		//int i=1/0;//模拟突发断电
		accountDao.in(inUser, money);
	}
	@Override
	public void q() {
		// TODO Auto-generated method stub
		System.out.println("q开始");
		//AccountService service = (AccountService) AopContext.currentProxy(); //获取代理对象
		try
		{
			transfer("aaa", "bbb", 200);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("断电");
		int i =1 /0;
		System.out.println("q结束");
	}
	@Override
	public void a() {
		// TODO Auto-generated method stub
		q();
		System.out.println("a");
	}
}
