package Springsource1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//������ʱִ��  
@Retention(RetentionPolicy.RUNTIME)  
//ע�����õط�(�ֶκͷ���)  
@Target({ElementType.METHOD,ElementType.FIELD}) 
public @interface MyValue
{
	 //ע���name����  
    public  String value();  
}
