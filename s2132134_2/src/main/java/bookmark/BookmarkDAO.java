package bookmark;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				Booklist p = new Booklist(id, title, author, created_at);
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
			String sql = "select books.id, title, author, created_at  from favorites inner join books on favorites.book_id = books.id where user_id = ?;";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,userID);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				String created = rs.getString("CREATED_AT");
				Date created_at = Date.valueOf(created);
				Booklist p = new Booklist(id, title, author, created_at);
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
				book = new Booklist(id, title, author, created_at);
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
	
	public List<ReviewModel> Reviewlist(int bookId) {
		List<ReviewModel> list = new ArrayList<>();
		String url = "jdbc:h2:tcp://localhost/~/s2132134";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "select * from reviews where book_id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, bookId);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				int userId = rs.getInt("USER_ID");
				String title = rs.getString("TITLE");
				String comment = rs.getString("COMMENT");
				list.add(new ReviewModel(id, bookId, userId, title, comment));
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
