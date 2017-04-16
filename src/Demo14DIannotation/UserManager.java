package Demo14DIannotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
@Service("userManagerId")
public class UserManager
{
	
	private UserDao userDao;

	public UserDao getUserDao()
	{
		return userDao;
	}
	@Resource(name="userDaoid")
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
}
