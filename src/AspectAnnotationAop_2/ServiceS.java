package AspectAnnotationAop_2;

import org.springframework.stereotype.Component;

@Component("service")
public class ServiceS {

	public void run(){
		System.out.println("run");
	}
}
