package dto;

import java.io.Serializable;

public class Shift implements Serializable {
		/*フィールド*/
		private int id; 
		private String user_id;		
		private String date;		
		private String in; 			
		private String out; 				
		private String real_in; 		
		private String real_out; 
	
		/*コンストラクタ*/
		public Shift() {
			super();
			this.id = 0;
			this.user_id = "";
			this.date = "";
			this.in = "";
			this.out = "";
			this.real_in = "";
			this.real_out = "";
		}
		
		public Shift(int id, String user_id, String date, String in, String out, String real_in,
				String real_out) {
			super();
			this.id = id;
			this.user_id = user_id;
			this.date = date;
			this.in = in;
			this.out = out;
			this.real_in = real_in;
			this.real_out = real_out;
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

		public String getIn() {
			return in;
		}

		public void setIn(String in) {
			this.in = in;
		}

		public String getOut() {
			return out;
		}

		public void setOut(String out) {
			this.out = out;
		}

		public String getReal_in() {
			return real_in;
		}

		public void setReal_in(String real_in) {
			this.real_in = real_in;
		}

		public String getReal_out() {
			return real_out;
		}

		public void setReal_out(String real_out) {
			this.real_out = real_out;
		}
		
}