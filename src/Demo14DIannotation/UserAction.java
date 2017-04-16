package Demo14DIannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("userActionID")
public class UserAction
{
	@Autowired
	public WorkDaoImpl workDao  ;
	public void h(){
		workDao.work();
	}
}
