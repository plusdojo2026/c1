package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// 日付や時刻のフォーマットの指定
import java.text.SimpleDateFormat;
// 現在の年月日を取得する
import java.util.Calendar;

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
//			String sql = "SELECT suggestion.id ,user.user_name ,suggestion.suggestion "+
//						"FROM suggestion INNER JOIN user ON suggestion.user_id = user.user_id "+
//						"INSERT INTO suggestion VALUES (0, ?, ?)";
			
//			日付を取得し変数をを格納
			Calendar cl = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			
			// SQL文を準備する(idは自動連番なので指定しなくてよい)
			String sql = "INSERT INTO suggestion VALUES(0, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			// SQL文の「？」に使用する値を設定してSQL文を完成
			// pStmt.setString(1, card.getUser_id());
	        // 日付を格納させる
			// pStmt.setString(2, sdf.format(cl.getTime()));
			// pStmt.setString(3, card.getSuggestion());
	        
	     // SQL文を完成させる
	     			if (card.getUser_id() != null) {
	     				pStmt.setString(1, card.getUser_id());
	     				//System.out.println(card.getUser_id());
	     			} else {
	     				pStmt.setString(1, "");
	     			}
	     			if (sdf.format(cl.getTime()) != null) {
	     				pStmt.setString(2, sdf.format(cl.getTime()));
	     			} else {
	     				pStmt.setString(2, "");
	     			}
	     			if (card.getSuggestion() != null) {
	     				pStmt.setString(3, card.getSuggestion());
	     			} else {
	     				pStmt.setString(3, "");
	     			}

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