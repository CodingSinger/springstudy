package Demo4Instance;

public class ServiceFactory
{
	public static BookService newInstance(){
		return new BookService();
	}
}
