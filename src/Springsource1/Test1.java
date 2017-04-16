package Springsource1;

import java.util.HashMap;

public class Test1
{
	public static void main(String[] args){
		HashMap hashMap = new HashMap();
		hashMap.put("a", new a());
		a b = (a) hashMap.get("a");
		b.c=2;
		a b2 = (a) hashMap.get("a");
		System.out.println(b2.c);
	}

}

class a{
	int c;
}