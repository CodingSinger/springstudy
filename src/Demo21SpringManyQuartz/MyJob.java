package Demo21SpringManyQuartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *工作�? */
public class MyJob implements Job {
	// �?��继承job
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("现在时间: " + new Date()+"job1");
	}
}