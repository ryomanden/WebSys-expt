package bookmark;

public class FavoriteModel {
	private int id;
	private int bookId;
	private int userId;
	
	public FavoriteModel(int id, int bookId, int userId) {
		this.id = id;
		this.bookId = bookId;
		this.userId = userId;
	}

	public FavoriteModel(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public int getUserId() {
		return userId;
	}
}
