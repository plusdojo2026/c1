package dto;

import java.io.Serializable;

//authorityテーブルのDTO（JavaBeans形式）
public class Authority implements Serializable {
	private int authority_id;	// authority_id列
	private String authority;	// authority列
	
	// authority_idのゲッタ
	public int getAuthority_id() {
		return authority_id;
	}
	
	// authority_idのセッタ
	public void setAuthority_id(int authority_id) {
		this.authority_id = authority_id;
	}

	// authorityのゲッタ
	public String getAuthority() {
		return authority;
	}

	// authorityのセッタ
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	// 引数がないコンストラクタ
	public Authority() {
		super();
		this.authority_id = 0;
		this.authority = "";
	}

	// 引数があるコンストラクタ
	public Authority(int authority_id, String authority) {
		this.authority_id = authority_id;
		this.authority = authority;
	}
}

