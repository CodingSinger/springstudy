package Springsource1;

import org.junit.Test;

public class ThisTest
{
	
	public static void main(String[] args){
		MyClassPathXmlApplicationContext app = new MyClassPathXmlApplicationContext("Springsource1/beans.xml");
		Mybean bean = (Mybean) app.getBean("mybeanid");
		System.out.println(bean);
	}
}
