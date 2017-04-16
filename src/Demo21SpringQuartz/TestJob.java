package Demo21SpringQuartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class TestJob extends QuartzJobBean 
{
//	@Scheduled(cron="0 42/3 * * * ?")//ÿСʱ��33���ӿ�ʼִ�У�ÿ3����ִ��1��
//	public void run(){
//		System.out.println("hahah");
//	}
	// �ƻ�����������  
    private String targetObject;  
  
    // ������Ҫִ�еļƻ�����  
    private String targetMethod;  
    private ApplicationContext ctx;  
  
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException
	{
		// TODO Auto-generated method stub
		System.out.println("hahah");
	}
	  public void setApplicationContext(ApplicationContext applicationContext) {  
	        this.ctx = applicationContext;  
	    }  
	  
	    public void setTargetObject(String targetObject) {  
	        this.targetObject = targetObject;  
	    }  
	  
	    public void setTargetMethod(String targetMethod) {  
	        this.targetMethod = targetMethod;  
	    }  
}
