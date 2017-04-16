package Demo14DIannotation;

import org.springframework.stereotype.Repository;

@Repository("userDaoid")
public class UserDao
{
	public void add(){
		System.out.println("add user");
	}
}
