package dto;

import java.io.Serializable;

public class Checker implements Serializable {
	
		/*フィールド*/
		private int id; 
		private int notice_id; 
		private String user_id;			
		
		/* 引数が空のコンストラクタ */
		public Checker () {
			super();
			this.id = 0;
			this.notice_id = 0;
			this.user_id = "";
		}
		
		/* 引数のあるコンストラクタ */
		public Checker (int id, int notice_id, String user_id) {
			super();
			this.id = id;
			this.notice_id = notice_id;
			this.user_id = user_id;
		}

		/* idのゲッタセッタ */
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		/* notice_idのゲッタセッタ */
		public int getNotice_id() {
			return notice_id;
		}
 
		public void setNotice_id(int notice_id) {
			this.notice_id = notice_id;
		}
		
		/* user_idのゲッタセッタ */
		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		
}
