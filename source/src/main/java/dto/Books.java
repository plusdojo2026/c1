package dto;

import java.io.Serializable;

//EmployeeテーブルのDTO（JavaBeans形式）
public class Books implements Serializable {
	private String number;	// number列
	private String title;	// name列
	private String date;	// date列
	private String registrant; // registrant列
	private String maintext;  // maintext列
	
	// numberのゲッタ
	public String getNumber() {
		return number;
	}
	
	// numberのセッタ
	public void setNumber(String number) {
		this.number = number;
	}

	// titleのゲッタ
	public String getTitle() {
		return title;
	}

	// titleのセッタ
	public void setTitle(String title) {
		this.title = title;
	}

	// dateのゲッタ
	public String getDate() {
		return date;
	}
	
	// dateのセッタ
	public void setDate(String date) {
		this.date = date;
	}
	
	// dateのゲッタ
	public String getRegistrant() {
		return registrant;
	}
	
	// dateのセッタ
	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}
	
	// maintextのゲッタ
	public String getMaintext() {
		return maintext;
	}
	
	// maintextのセッタ
	public void setMaintext(String maintext) {
		this.maintext = maintext;
	}

	// 引数がないコンストラクタ
	public Books() {
		this("", "","","","");
	}

	// 引数があるコンストラクタ
	public Books(String number, String title, String date, String registrant, String maintext) {
		this.number = number;
		this.title = title;
		this.date = date;
		this.registrant = registrant;
		this.maintext = maintext;
	}
}
