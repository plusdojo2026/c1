package dto;

import java.io.Serializable;

public class Suggestion implements Serializable {
		/*フィールド*/
		private int id; 
		private String user_id;		
		private String suggestion;		
		
		/*コンストラクタ*/
		public Suggestion() {
			super();
			this.id = 0;
			this.user_id = "";
			this.suggestion = "";
		}
		
		public Suggestion(int id, String user_id, String date, String suggestion) {
			super();
			this.id = id;
			this.user_id = user_id;
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

		public String getSuggesstion() {
			return suggestion;
		}

		public void setSuggesstion(String suggesstion) {
			this.suggestion = suggesstion;
		}
		
}
