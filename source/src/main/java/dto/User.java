package dto;

import java.io.Serializable;

public class User implements Serializable {
	private int user_id;		// ユーザーID
	private String user_name;	// ユーザーネーム
	private String password;	// パスワード
	private String authority_id; // 権限id

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return user_name;
	}
	
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAuthorityId() {
		return authority_id;
	}
	
	public void setAuthorityId(String authority_id) {
		this.authority_id = authority_id;
	}
	
	// 引数のあるコンストラクタ
	public User(int user_id, String user_name, String password, String authority_id) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.authority_id =authority_id;
		
	}
	
	// 引数のないコンストラクタ
	public User() {
		super();
		user_id = 0;
		user_name = "";
		password = "";
		authority_id = "";
	}
}
	