package SpringQuartzAnnotation;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class TestJob 
{
		@Scheduled(cron="*/4 * * * * *") 
	    public void buildOnTimer(){
			 System.out.println("4");
	    }
	    
	    @Scheduled(cron="*/10 * * * * *") 
	    public void s10(){
	        System.out.println("10s");
	    }
	    
	    @Scheduled(cron="0 */1 * * * *") 
	    public void m1(){
	        System.out.println("1m");
	    }
	    @Scheduled(cron="0 */2 * * * *") 
	    public void h1(){
	        System.out.println("2m");
	    }
}
