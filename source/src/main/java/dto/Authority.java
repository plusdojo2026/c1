package dto;

import java.io.Serializable;

//authorityテーブルのDTO（JavaBeans形式）
public class Authority implements Serializable {
	private String authority_id;	// authority_id列
	private String authority;	// authority列
	
	// idのゲッタ
	public String getId() {
		return authority_id;
	}
	
	// idのセッタ
	public void setAuthority_id(String Authority_id) {
		this.authority_id = authority_id;
	}

	// user_idのゲッタ
	public String getAuthority() {
		return authority;
	}

	// user_idのセッタ
	public void setAuthority(String Authority) {
		this.authority = authority;
	}

	// 引数がないコンストラクタ
	public Authority() {
		this("","");
	}

	// 引数があるコンストラクタ
	public Authority(String authority_id, String authority) {
		this.authority_id = authority_id;
		this.authority = authority;
	}
}

