package dto;

import java.io.Serializable;

//BooksテーブルのDTO（JavaBeans形式）
public class Books implements Serializable {
<<<<<<< Updated upstream
	private int id;				// id列
	private String user_id;		// user_id列
	private String date;		// date列
	private int category_id; 	// category_id列
	private String title;  		// title列
	private String teacher;  	// teacher列
	private String manual;  	// manual列
=======
	private int id;	// id列
	private String user_id;	// user_id列
	private String date;	// date列
	private String category_id; // category_id列
	private String title;  // title列
	private String teacher;  // teacher列
	private String manual;  // manual列
>>>>>>> Stashed changes
	private String update_name;  // update_name列
	private String update_date;  // update_Date列
	
	// idのゲッタ
	public int getId() {
		return id;
	}
	
	// idのセッタ
<<<<<<< Updated upstream
	public void setId(int id) {
=======
	public void setId(int Id) {
>>>>>>> Stashed changes
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
	public int getCategory_id() {
		return category_id;
	}
	
	// category_idのセッタ
	public void setCategory_id(int category_id) {
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
	public String getManual() {
		return manual;
	}
	
	// manualのセッタ
	public void setManual(String manual) {
		this.manual = manual;
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

	// 引数がないコンストラクタ
	public Books() {
<<<<<<< Updated upstream
		super();
		this.id = 0;
		this.user_id = "";
		this.date = "";
		this.category_id = 0;
		this.title = "";
		this.teacher = "";
		this.manual = "";
		this.update_name = "";
		this.update_date = "";
=======
		this(0,"","","","","","","","");
>>>>>>> Stashed changes
	}
	
	// 引数があるコンストラクタ
<<<<<<< Updated upstream
	public Books(int id, String user_id, String date, int category_id, String title
=======
	public Books(int id, String user_id, String date, String category_id, String title
>>>>>>> Stashed changes
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
