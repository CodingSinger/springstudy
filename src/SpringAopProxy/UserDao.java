package SpringAopProxy;

import org.springframework.stereotype.Component;

@Component("userDaoId")
public class UserDao 
{
	/* (non-Javadoc)
	 * @see SpringAopProxy.UserD#add()
	 */
	public void add(){
		System.out.println("add");
	}
	/* (non-Javadoc)
	 * @see SpringAopProxy.UserD#delete()
	 */
	public void delete(){
		System.out.println("delete");
	}
}
