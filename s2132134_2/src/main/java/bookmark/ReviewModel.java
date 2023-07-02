package bookmark;

public class ReviewModel {
	private int reviewId;
	private int bookId;
	private int userId;
	private String reviewTitle;
	private String comment;
	private String userName;
	private String bookTitle;
	private String bookAuthor;
	
	public ReviewModel(int reviewId,int bookId,int userId,String reviewTitle,String comment,String userName) {
		this.reviewId = reviewId;
		this.bookId = bookId;
		this.userId = userId;
		this.reviewTitle = reviewTitle;
		this.comment = comment;
		this.userName = userName;
	}
	public ReviewModel(int reviewId,int bookId,int userId,String reviewTitle,String comment,String bookTitle,String bookAuthor) {
		this.reviewId = reviewId;
		this.bookId = bookId;
		this.userId = userId;
		this.reviewTitle = reviewTitle;
		this.comment = comment;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}
	
	public int getReviewId() {
		return reviewId;
	}
	public int getBookId() {
		return bookId;
	}
	public int getUserId() {
		return userId;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public String getComment() {
		return comment;
	}
	public String getUserName() {
		return userName;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
}