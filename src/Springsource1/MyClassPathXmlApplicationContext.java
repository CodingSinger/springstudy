package Springsource1;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class MyClassPathXmlApplicationContext
{
	private HashMap<String,Object> objhashMap;
	private HashMap<String,String> xmlConfig;
	private String fileName="Springsource1/beans.xml";
	public MyClassPathXmlApplicationContext(String fileName){
		xmlConfig = new HashMap<String,String>();
		objhashMap = new HashMap<String,Object>();
		LoadXml();
		this.LoadAllObject();
		this.LoadAnnotation();
	}
	protected MyClassPathXmlApplicationContext(){
		
	}
	@Test
	protected void LoadXml(){
		SAXReader rd=new SAXReader();
		Document dc = null;
		try
		{
			dc =rd.read(this.getClass().getClassLoader().getResourceAsStream(fileName));
		}
		catch (DocumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root = dc.getRootElement(); 
	//	List list = dc.selectNodes("//bean");
		for (Iterator i = root.elementIterator(); i.hasNext();) {  
	        Element el = (Element) i.next();
	        
	        String id = el.attributeValue("id");
	        String className = el.attributeValue("class");
	        xmlConfig.put(id,className);
	    }  
		
		
	}
	
	protected Object getBean(String name){
		return objhashMap.get(name);
	}
	
	protected void LoadAnnotation(){//得到每个类的字段是否有注解
		Set<Entry<String, Object>> entrys = objhashMap.entrySet();
		Iterator it = entrys.iterator();
		while(it.hasNext()){
			Map.Entry<String, Object> entry = (Entry<String, Object>) it.next();
			String id = entry.getKey();
			Object obj = entry.getValue();
			Field[] fileds = obj.getClass().getDeclaredFields();//得到所有字段
			for(Field field:fileds){//得到该字段所有的注解
				Annotation[] as = field.getAnnotations();
				for(Annotation a:as){//判断是否是MyValue注解
					if(a instanceof MyValue){//如果是
						try{
							field.setAccessible(true);//设置成可读写
							if(field.getType()==int.class){//判断类型
								field.setInt(obj, Integer.valueOf(((MyValue) a).value()));
							}
							
						
							else{
								field.set(obj, ((MyValue) a).value());
							}
							}catch(Exception e){
								e.printStackTrace();
							}
					}
				}
			}
		}
		
	}
	
	protected void LoadAllObject(){//加载成对象的实例保存
		Set<Entry<String, String>> entrys = xmlConfig.entrySet();
		Iterator it = entrys.iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = (Entry<String, String>) it.next();
			String id = entry.getKey();
			String name = entry.getValue();
			try
			{
				Class clazz = Class.forName(name);
				Object obj = clazz.newInstance();
				objhashMap.put(id, obj);
			}
			catch (Exception e)
			{
				
				e.printStackTrace();
			}
		}
	}
}
