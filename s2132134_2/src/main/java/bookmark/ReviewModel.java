package bookmark;

public class ReviewModel {
	private int reviewId;
	private int bookId;
	private int userId;
	private String reviewTitle;
	private String comment;
	
	public ReviewModel(int reviewId,int bookId,int userId,String reviewTitle,String comment) {
		this.reviewId = reviewId;
		this.bookId = bookId;
		this.userId = userId;
		this.reviewTitle = reviewTitle;
		this.comment = comment;
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
}