package dto;

import java.io.Serializable;

public class Notice implements Serializable {
		/*フィールド*/
		private int id; 
		private String user_id;		
		private String registTitle;		
		private String date; 			
		private String registText; 				
	
		/*コンストラクタ*/
		public Notice() {
			super();
			this.id = 0;
			this.user_id = "";
			this.registTitle = "";
			this.date = "";
			this.registText = "";

		}
		
		public Notice(int id, String user_id, String registTitle, String date,  String registText) {
			super();
			this.id = id;
			this.user_id = user_id;
			this.registTitle = registTitle;
			this.date = date;
			this.registText = registText;
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
			return registTitle;
		}

		public void setRegistTitle(String registTitle) {
			this.registTitle = registTitle;
		}
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getregistText() {
			return registText;
		}

		public void setregistText(String registText) {
			this.registText = registText;
		}

}