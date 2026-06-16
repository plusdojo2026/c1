package dto;

import java.io.Serializable;

public class Suggestion implements Serializable {
		/*フィールド*/
		private int id; 
		private String user_name;		
		private String suggestion;		
		
		/*コンストラクタ*/
		public Suggestion() {
			super();
			this.id = 0;
			this.user_name = "";
			this.suggestion = "";
		}
		
		public Suggestion(int id, String user_id, String suggestion, String user_name) {
			super();
			this.id = id;
			this.user_name = user_name;
			this.suggestion = suggestion;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getSuggestion() {
			return suggestion;
		}

		public void setSuggestion(String suggestion) {
			this.suggestion = suggestion;
		}

}