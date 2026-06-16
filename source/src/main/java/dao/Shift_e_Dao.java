package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Shift;

public class Shift_e_Dao {
	// 引数shift指定された項目で検索して、取得されたデータのリストを返す
	public List<Shift> select(Shift shift) {
		Connection conn = null;
		List<Shift> shiftList = new ArrayList<Shift>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT shift.id, user.user_name, shift.date, " +
		            "shift.clock_in, shift.clock_out, shift.real_in, shift.real_out " +
		            "FROM shift INNER JOIN user ON shift.user_id = user.user_id "+
		            "WHERE user.user_name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			
			pStmt.setString(1, shift.getUser_name());
			
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Shift s = new Shift(rs.getInt("id"), rs.getString("user_name"), rs.getString("date"), 
							rs.getString("clock_in"), rs.getString("clock_out"), rs.getString("real_in"), 
							rs.getString("real_out"));
				shiftList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			shiftList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			shiftList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					shiftList = null;
				}
			}
		}

		// 結果を返す
		return shiftList;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Shift card) {
	    Connection conn = null;
	    boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "INSERT INTO shift VALUES (0, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
	        pStmt.setString(1, card.getUser_name());
	        pStmt.setString(2, card.getDate());
	        pStmt.setString(3, card.getClock_in());
	        pStmt.setString(4, card.getClock_out());
	        pStmt.setString(5, card.getReal_in());
	        pStmt.setString(6, card.getReal_out());
			
			
			

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