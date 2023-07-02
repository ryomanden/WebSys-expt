package bookmark;

public class AuthModel {
	private int userId;
	private String userName;
	private String passwd;
	
	public AuthModel(int userId, String userName, String passwd) {
		this.userId = userId;
		this.userName = userName;
		this.passwd = passwd;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPasswd() {
		return passwd;
	}

}
