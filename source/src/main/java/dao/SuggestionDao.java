package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Suggestion;

public class SuggestionDao {
// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Suggestion card) {
	    Connection conn = null;
//	    boolean result = false;
	    
	    try {
	    	// JDBCドライバを読み込む
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e){
	    	throw new IllegalStateException(
	    			"JDBCドライバを読み込めませんでした。");
	    }
	    
		try {
			

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
//			String sql = "SELECT suggestion.id ,user.user_name ,suggestion.suggestion "+
//						"FROM suggestion INNER JOIN user ON suggestion.user_id = user.user_id "+
//						"INSERT INTO suggestion VALUES (0, ?, ?)";
			
			// SQL文を準備する(idは自動連番なので指定しなくてよい)
			String sql = "INSERT INTO suggestion(user_id, suggestion) VALUES(?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			// SQL文の「？」に使用する値を設定してSQL文を完成
	        pStmt.setString(1, card.getUser_id());
	        pStmt.setString(2, card.getSuggestion());
	        
	        // INSERT文を実行(resultには追加された行数が代入される)
	         int result = pStmt.executeUpdate();
	        if (result != 1) {
	        	return false;
	        }
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	        
	        

		// 結果を返す
		return true;
	}
}