package user;

// Java Beans 로 유저 테이블 구축 => JSP에서 데이터를 관리하고 처리할 수 있게 한다 
// 회원 데이터 구축 


public class User {
	
	private String userID;
	
	private String userPassword;
	
	private String userName;
	
	private String userGender;
	
	private String userEmail;
	
	

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	

	
}
