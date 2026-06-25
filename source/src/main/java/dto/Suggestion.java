package dto;

import java.io.Serializable;

public class Suggestion implements Serializable {
		/*フィールド*/
		private int id; 
		private String user_id;	
		private String user_name;
		private String suggestion_date;
		private String suggestion;		
		
		/*コンストラクタ*/
		public Suggestion() {
			super();
			this.id = 0;
			this.user_id = "";
			this.user_name = "";
			this.suggestion_date = "";
			this.suggestion = "";
		}
		
		/* ホーム画面にてご意見箱送信に使うもの */
		public Suggestion(int id, String user_id, String suggestion_date, String suggestion) {
			super();
			this.id = id;
			this.user_id = user_id;
			this.suggestion_date = suggestion_date;
			this.suggestion = suggestion;
		}
		
		/* マイページ画面にてご意見箱表示に使うもの */
		public Suggestion(int id, String user_id, String user_name, String suggestion_date, String suggestion) {
			super();
			this.id = id;
			this.user_id = user_id;
			this.user_name = user_name;
			this.suggestion_date = suggestion_date;
			this.suggestion = suggestion;
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
		
		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		
		public String getSuggestion_date() {
			return suggestion_date;
		}

		public void setSuggestion_date(String suggestion_date) {
			this.suggestion_date = suggestion_date;
		}
		
		public String getSuggestion() {
			return suggestion;
		}

		public void setSuggestion(String suggestion) {
			this.suggestion = suggestion;
		}

}