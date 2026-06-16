package dto;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String user_id; // ログイン時のユーザーID

	public String getUserId() {
		return user_id;
	}

	public void setUserId(String user_id) {
		this.user_id = user_id;
	}

	public LoginUser() {
		this(null);
	}

	public LoginUser(String user_id) {
		this.user_id = user_id;
	}
}