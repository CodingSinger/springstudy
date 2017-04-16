package Demo14DIannotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo14
{
	/*
	 * org.springframework.beans.factory.BeanDefinitionStoreException: Unexpected exception parsing XML document from class path resource [Demo14DIannotation/beans.xml]; 
	 * nested exception is java.lang.NoClassDefFoundError: org/springframework/aop/TargetSource
		Caused by: java.lang.NoClassDefFoundError: org/springframework/aop/TargetSource
	
		Caused by: java.lang.ClassNotFoundException: org.springframework.aop.TargetSource


	 * 报错原因:
	 *  未导入org.springframework.aop-3.0.5.RELEASE.jar
	 */
	
	/*
	 * @Controller  修饰web层
		@Service 修饰service层
		@Repository 修饰dao层


			依赖注入：添加到字段或setter方法都可以
			方式1：普通数据
			@Value
			方式2：引用数据
			@Autowired  ，默认按照类型进行注入
			@Qualifier ，按照名称注入(这两者通常结合使用)
		方式3：引用数据
		@Resource ，直接按照名称注入。与“方式2”的两个注解等效的。
			例如：@Resource(name="名称")
			@PostConstruct修饰初始化方法
			@PreDestroy修饰销毁方法
	 */
	@Test
	public void Demo14_1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Demo14DIannotation/beans.xml");
		MyBean myBean = (MyBean) applicationContext.getBean("MybeanId");
		MyBean myBean3 = (MyBean) applicationContext.getBean("MybeanId");
		//注解写在实现类上 写在接口上报错找不到类
		WorkDaoImpl workDao = (WorkDaoImpl) applicationContext.getBean("workDao");
		Inter inter = (Inter) applicationContext.getBean("inter");
		inter.play();
		workDao.work();
		System.out.println(myBean3);
		System.out.println(myBean);
		UserService myBean2 = (UserService) applicationContext.getBean("UserServiceId");
		UserManager manager = (UserManager)applicationContext.getBean("userManagerId");
		manager.getUserDao().add();
		myBean2.getUserDao().add();
		UserAction ac = (UserAction) applicationContext.getBean("userActionID");
		ac.h();
		UserAction ac1 = new UserAction();//虽然注册过的bean也能够new，但动态注入的将会空指针
		ac1.h();
		applicationContext.destroy();
	}
}
