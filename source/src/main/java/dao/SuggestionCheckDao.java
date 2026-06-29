//suggestionテーブルを検索して、ヒットした全件を表示させる
//Mypageから入力できるものはない(入力はどこにも送信しない、受け付けない)

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Suggestion;

public class SuggestionCheckDao {
	
	
	// 引数card指定された項目で検索して、取得されたデータのリストを返す(セレクトメソッド)
	public List<Suggestion> select(Suggestion Suggestion) {
		Connection conn = null;
		List<Suggestion> suggestionList = new ArrayList<>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
//					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements"
//					+ "=true","root", "password");
			
//			アップロードの際にコメントアウトを外す
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"c1", "c3aXB3a6xd7ursUv");

			// SQL文を準備する(user_name、suggestion_date、suggestionを取り出す)
			String sql = "SELECT suggestion.id, user.user_id, user.user_name, suggestion.suggestion_date, suggestion.suggestion "
					+ "FROM suggestion INNER JOIN user ON suggestion.user_id = user.user_id;";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);

			
//			?がなく、setするものがないため以下のものはいらない、そのためコメントアウト
			// user_nameとsuggestionをセットする
//			pStmt.setString(user_name);
//			pStmt.setString(suggestion_date);
//			pStmt.setString(suggestion);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Suggestion s = new Suggestion(
						rs.getInt("id"), 
						rs.getString("user_id"),
						rs.getString("user_name"),
						rs.getString("suggestion_date"),
						rs.getString("suggestion"));
				suggestionList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			suggestionList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			suggestionList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					suggestionList = null;
				}
			}
		}

		// 結果を返す
		return suggestionList;
	}

}
