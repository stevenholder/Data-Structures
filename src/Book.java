
public class Book {
	private String title;
	private String author;
	
	public Book() {
		this("No Title");
	}
	
	public Book(String title) {
		this(title, "No Author");
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

}
