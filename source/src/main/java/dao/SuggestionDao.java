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
	    boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT suggestion.id ,user.user_name ,suggestion.suggestion "+
						"FROM suggestion INNER JOIN user ON suggestion.user_id = user.user_id "+
						"INSERT INTO suggestion VALUES (0, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
	        
	        pStmt.setString(2, card.getUser_name());
	        pStmt.setString(3, card.getSuggestion());
	        
			
			
			

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}