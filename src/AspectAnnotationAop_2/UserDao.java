package AspectAnnotationAop_2;

import org.springframework.stereotype.Component;
@Component("userDaoId")
public class UserDao 
{
	public void add(){
		System.out.println("add");
	}

	public void delete(){
		System.out.println("delete");
	}
}
