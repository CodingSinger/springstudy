package Demo2DI;

public class BookService
{
	private BookDao bookDao;

	public BookDao getBookDao()
	{
		return bookDao;
	}

	public void setBookDao(BookDao bookDao)
	{
		this.bookDao = bookDao;
	}
	public void add(){
		bookDao.save();
	}
}
