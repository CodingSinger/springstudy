package Demo5NostaticInstance;

public class ServiceFactory
{
	public BookService newInstance(){
		return new BookService();
	}
}
