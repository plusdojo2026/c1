package dto;

import java.io.Serializable;

public class Notice implements Serializable {
		/*フィールド*/
		private int id; 
		private String user_id;		
		private String date;		
		private String title; 			
		private String notice; 
		private String update_name;
		private String update_date;
	
		/*コンストラクタ*/
		public Notice() {
			super();
			this.id = 0;
			this.user_id = "";
			this.date = "";
			this.title = "";
			this.notice = "";
			this.update_name = "";
			this.update_date = "";

		}
		
		public Notice(int id, String user_id, String date, String title,  String notice, 
				String update_name, String update_date	) {
			super();
			this.id = id;
			this.user_id = user_id;
			this.date = date;
			this.title = title;
			this.notice = notice;
			this.update_name = update_name;
			this.update_date = update_date;
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

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getNotice() {
			return notice;
		}

		public void setNotice(String notice) {
			this.notice = notice;
		}

		public String getUpdate_name() {
			return update_name;
		}

		public void setUpdate_name(String update_name) {
			this.update_name = update_name;
		}

		public String getUpdate_date() {
			return update_date;
		}

		public void setUpdate_date(String update_date) {
			this.update_date = update_date;
		}
}
