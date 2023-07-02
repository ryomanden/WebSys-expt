package bookmark;

public class UserModel {
	private int userId;
	private String userName;
	private String userPass;
	private String userBio;
	
	public UserModel(int userId, String userName, String userPass, String userBio) {
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userBio = userBio;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserPass() {
		return userPass;
	}
	
	public String getUserBio() {
		return userBio;
	}
}
