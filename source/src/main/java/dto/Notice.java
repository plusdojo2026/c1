package dto;

import java.io.Serializable;

public class Notice implements Serializable {
		/*フィールド*/
		private int id; 
		private String user_id;		
		private String title;		
		private String date; 			
		private String text; 				
	
		/*コンストラクタ*/
		public Notice() {
			super();
			this.id = 0;
			this.user_id = "";
			this.title = "";
			this.date = "";
			this.text = "";

		}
		
		public Notice(int id, String user_id, String title, String date,  String text) {
			super();
			this.id = id;
			this.user_id = user_id;
			this.title = title;
			this.date = date;
			this.text = text;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		
		public String getRegistTitle() {
			return title;
		}

		public void settitle(String title) {
			this.title = title;
		}
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String gettext() {
			return text;
		}

		public void settext(String text) {
			this.text = text;
		}

}