package Demo14DIannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("UserServiceId")
public class UserService
{

	@Qualifier("userDaoid")
	private UserDao userDao;

	public UserDao getUserDao()
	{
		return userDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
}
