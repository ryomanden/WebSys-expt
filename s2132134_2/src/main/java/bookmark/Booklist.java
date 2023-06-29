package bookmark;
import java.sql.Date;

public class Booklist {
	private int bookId;
	private String title;
	private String author;
	private Date created_at;
	
	public Booklist(int bookId, String title,String author, Date created_at) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.created_at = created_at;
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
		return created_at;
	}
}
