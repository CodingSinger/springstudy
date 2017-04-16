package AspectXmlAop;

import org.springframework.stereotype.Component;

public class UserDao 
{
	public void add(){
		System.out.println("add");
	}

	public void delete(){
		System.out.println("delete");
	}
}
