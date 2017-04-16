package Demo14DIannotation;

import org.springframework.stereotype.Repository;

@Repository("workDao")
public class WorkDaoImpl implements WorkDao {
	/* (non-Javadoc)
	 * @see Demo14DIannotation.WorkDao#work()
	 */
	@Override
	public void work(){
		System.out.println("work");
	}
}
