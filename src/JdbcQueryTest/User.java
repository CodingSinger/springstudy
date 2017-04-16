package JdbcQueryTest;

public class User
{
	private String user;
	private String money;
	private int id;
	public String getUser()
	{
		return user;
	}
	public String getMoney()
	{
		return money;
	}
	public int getId()
	{
		return id;
	}
	public void setUser(String user)
	{
		this.user = user;
	}
	public void setMoney(String money)
	{
		this.money = money;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	@Override
	public String toString()
	{
		return "User [user=" + user + ", money=" + money + ", id=" + id + "]";
	}
	
}
