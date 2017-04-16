package Demo11PnamespaceDi;

public class BookService
{
	private BookDao bookDao;
	private String name;
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

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
