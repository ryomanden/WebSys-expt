package bookmark;
import java.sql.Date;

public class Booklist {
	private int bookId;
	private String title;
	private String author;
	private Date createdAt;
	
	public Booklist(int bookId, String title,String author, Date createdAt) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.createdAt = createdAt;
	}
	
	public int getBookId() {
		return bookId;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
}
