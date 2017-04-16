package Demo21SpringQuartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class TestJob extends QuartzJobBean 
{
//	@Scheduled(cron="0 42/3 * * * ?")//每小时的33分钟开始执行，每3分钟执行1次
//	public void run(){
//		System.out.println("hahah");
//	}
	// 计划任务所在类  
    private String targetObject;  
  
    // 具体需要执行的计划任务  
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
