package Demo21AopTransaction;

public interface AccountService
{

	public abstract void setAccountDao(AccountDao accountDao);

	public abstract void transfer(String inUser, String outUser, int money) throws Exception;

	
	public void q();
	public void a();
}