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
	public List<Booklist> Booklist(int userId) {
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

}
