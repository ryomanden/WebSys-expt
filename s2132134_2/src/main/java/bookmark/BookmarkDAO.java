package bookmark;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookmarkDAO {
	
	static {
		try {
			Class.forName("org.h2.Driver"); // JDBC Driverの読み込み
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Booklist> Booklist() {
		List<Booklist> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/~/s2132134";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "SELECT * from books;";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				String created = rs.getString("CREATED_AT");
				Date created_at = Date.valueOf(created);
				LocalDate date = created_at.toLocalDate();
				String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				Booklist p = new Booklist(id, title, author, formattedDate);
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return list;
	}
	public List<Booklist> Booklist(int userID) {
		List<Booklist> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/~/s2132134";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select books.id, title, author, created_at from favorites inner join books on favorites.book_id = books.id where user_id = ?;";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,userID);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				String created = rs.getString("CREATED_AT");
				Date created_at = Date.valueOf(created);
				LocalDate date = created_at.toLocalDate();
				String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				Booklist p = new Booklist(id, title, author, formattedDate);
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		System.out.println(userID);
		return list;
	}
	public Booklist Book(int bookID) {
		Booklist book = null;
		String url = "jdbc:h2:tcp://localhost/~/s2132134";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "SELECT * FROM BOOKS where id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, bookID);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				String created = rs.getString("CREATED_AT");
				Date created_at = Date.valueOf(created);
				LocalDate date = created_at.toLocalDate();
				String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				book = new Booklist(id, title, author, formattedDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return book;
	}
	public UserModel User(int userID) {
		UserModel user = null;
		String url = "jdbc:h2:tcp://localhost/~/s2132134";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "SELECT * FROM USERS where id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, userID);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASSWD");
				String bio = rs.getString("BIOGRAPHY");
				user = new UserModel(id, name, pass, bio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return user;
	}
	public AuthModel Auth(String userName) {
		AuthModel auth = null;
		String url = "jdbc:h2:tcp://localhost/~/s2132134";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from users where name = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, userName);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASSWD");
				auth = new AuthModel(id, name, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return auth;
	}
	
	public List<ReviewModel> Reviewlist(int bookId) {
		List<ReviewModel> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/~/s2132134";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from reviews inner join users on reviews.user_id = users.id where book_id = ?;";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, bookId);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				int userId = rs.getInt("USER_ID");
				String title = rs.getString("TITLE");
				String comment = rs.getString("COMMENT");
				String userName = rs.getString("NAME");
				list.add(new ReviewModel(id, bookId, userId, title, comment,userName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return list;
	}
	public List<ReviewModel> UserReviewlist(int userID) {
		List<ReviewModel> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/~/s2132134";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select reviews.id, book_id, user_id, reviews.title, comment, books.title as book_title, author from reviews inner join books on reviews.book_id = books.id where user_id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, userID);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				int bookId = rs.getInt("BOOK_ID");
				String title = rs.getString("TITLE");
				String comment = rs.getString("COMMENT");
				String bookTitle = rs.getString("BOOK_TITLE");
				String author = rs.getString("AUTHOR");
				list.add(new ReviewModel(id, bookId, userID, title, comment,bookTitle,author));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return list;
	}
	
	

}
