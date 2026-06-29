package dto;

import java.io.Serializable;

//BooksテーブルのDTO（JavaBeans形式）
public class Books implements Serializable {
	private int id;				// id列
	private String user_id;		// user_id列
	private String date;		// date列
	private String category_id; 	// category_id列
	private String title;  		// title列
	private String teacher;  	// teacher列
	private String manual_x;  	// manual列
	private String update_name;  // update_name列
	private String update_date;  // update_Date列
	
	// 引数があるコンストラクタ
	public Books(int id, String user_id, String date, String category_id, String title,
			 String teacher, String manual_x, String update_name, String update_date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.date = date;
		this.category_id = category_id;
		this.title = title;
		this.teacher = teacher;
		this.manual_x = manual_x;
		this.update_name = update_name;
		this.update_date = update_date;
	}
	
	// 引数がないコンストラクタ
	public Books() {
		super();
		this.id = 0;
		this.user_id = "";
		this.date = "";
		this.category_id = "";
		this.title = "";
		this.teacher = "";
		this.manual_x = "";
		this.update_name = "";
		this.update_date = "";
	}
	
	// idのゲッタ
	public int getId() {
		return id;
	}
	
	// idのセッタ
	public void setId(int id) {
		this.id = id;
	}

	// user_idのゲッタ
	public String getUser_id() {
		return user_id;
	}

	// user_idのセッタ
	public void setUser_id(String user_id) {
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
	public void setTitle(String title) {
		this.title = title;
	}
	
	// teacherのゲッタ
	public String getTeacher() {
		return teacher;
	}
	
	// teacherのセッタ
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	// manualのゲッタ
	public String getManual_x() {
		return manual_x;
	}
	
	// manualのセッタ
	public void setManual_x(String manual_x) {
		this.manual_x = manual_x;
	}
	
	// update_nameのゲッタ
	public String getUpdate_name() {
		return update_name;
	}
	
	// update_nameのセッタ
	public void setUpdate_name(String update_name) {
		this.update_name = update_name;
	}
	
	// update_dateのゲッタ
	public String getUpdate_date() {
		return update_date;
	}
	
	// update_dateのセッタ
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
}
