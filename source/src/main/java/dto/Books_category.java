package dto;

import java.io.Serializable;

public class Books_category implements Serializable {
		/*フィールド*/
		private int category_id; 
		private String category;	
		
		/*コンストラクタ*/
		public Books_category() {
			super();
			this.category_id = 0;
			this.category = "";
		}
		
		public Books_category(int category_id, String category) {
			super();
			this.category_id = category_id;
			this.category = category;
		}

		public int getCategory_id() {
			return category_id;
		}

		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
}