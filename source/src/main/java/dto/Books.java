package dto;

import java.io.Serializable;

//BooksテーブルのDTO（JavaBeans形式）
public class Books implements Serializable {
	private String id;	// id列
	private String user_id;	// user_id列
	private String date;	// date列
	private String category_id; // category_id列
	private String title;  // title列
	private String teacher;  // teacher列
	private String manual;  // manual列
	private String update_name;  // update_name列
	private String update_date;  // update_Date列
	
	// idのゲッタ
	public String getId() {
		return id;
	}
	
	// idのセッタ
	public void setId(String Id) {
		this.id = id;
	}

	// user_idのゲッタ
	public String getUser_id() {
		return user_id;
	}

	// user_idのセッタ
	public void setUser_id(String User_id) {
		this.user_id = user_id;
	}

	// dateのゲッタ
	public String getDate() {
		return date;
	}
	
	// dateのセッタ
	public void setDate(String date) {
		this.date = date;
	}
	
	// category_idのゲッタ
	public String getCategory_id() {
		return category_id;
	}
	
	// category_idのセッタ
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	// titleのゲッタ
	public String getTitle() {
		return title;
	}
	
	// titleのセッタ
	public void setTitle(String Title) {
		this.title = title;
	}
	
	// teacherのゲッタ
	public String getTeacher() {
		return teacher;
	}
	
	// teacherのセッタ
	public void setTeacher(String Teacher) {
		this.teacher = teacher;
	}
	
	// manualのゲッタ
	public String getManual() {
		return manual;
	}
	
	// manualのセッタ
	public void setManual(String Manual) {
		this.manual = manual;
	}
	
	// update_nameのゲッタ
	public String getUpdate_name() {
		return update_name;
	}
	
	// update_nameのセッタ
	public void setUpdate_name(String Update_name) {
		this.update_name = update_name;
	}
	
	// update_dateのゲッタ
	public String getUpdate_date() {
		return update_date;
	}
	
	// update_dateのセッタ
	public void setUpdate_date(String Update_date) {
		this.update_date = update_date;
	}

	// 引数がないコンストラクタ
	public Books() {
		this("","","","","","","","","");
	}

	// 引数があるコンストラクタ
	public Books(String id, String user_id, String date, String category_id, String title
			, String teacher, String manual, String update_name, String update_date) {
		this.id = id;
		this.user_id = user_id;
		this.date = date;
		this.category_id = category_id;
		this.title = title;
		this.teacher = teacher;
		this.manual = manual;
		this.update_name = update_name;
		this.update_date = update_date;
	}
}
