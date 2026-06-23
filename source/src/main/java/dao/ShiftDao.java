package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dto.Shift;

public class ShiftDao {
	// 引数shift指定された項目で検索して、取得されたデータのリストを返す
	public List<Shift> select(Shift shift) {
	    Connection conn = null;
	    List<Shift> shiftList = new ArrayList<>();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/mamoral?"
	            + "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
	            "root", "password");

	        String sql =
	            "SELECT shift.id, user.user_name, shift.date, " +
	            "shift.clock_in, shift.clock_out, shift.real_in, shift.real_out " +
	            "FROM shift INNER JOIN user ON shift.user_id = user.user_id " +
	            "WHERE 1=1";

	        if (shift.getWord() != null && !shift.getWord().isEmpty()) {
	            sql += " AND (user.user_name LIKE ? OR user.user_id LIKE ?)";
	        }

	        if (shift.getYear() != null && !shift.getYear().isEmpty()) {
	            sql += " AND shift.date LIKE ?";
	        }

	        
	        if (shift.getMonth() != null && !shift.getMonth().isEmpty()) {
	            sql += " AND shift.date LIKE ?";
	        }

	        PreparedStatement pStmt = conn.prepareStatement(sql);

	        int index = 1;

	        if (shift.getWord() != null && !shift.getWord().isEmpty()) {
	            pStmt.setString(index++, "%" + shift.getWord() + "%");
	            pStmt.setString(index++, "%" + shift.getWord() + "%");
	        }

	        if (shift.getYear() != null && !shift.getYear().isEmpty()) {
	            pStmt.setString(index++, shift.getYear() + "%");  
	        }

	        if (shift.getMonth() != null && !shift.getMonth().isEmpty()) {
	            pStmt.setString(index++, "%-" + shift.getMonth() + "-%");
	        }

	        ResultSet rs = pStmt.executeQuery();

	        while (rs.next()) {
	            Shift s = new Shift(
	                rs.getInt("id"),
	                rs.getString("user_id"),
	                rs.getString("user_name"),
	                rs.getString("date"),
	                rs.getString("clock_in"),
	                rs.getString("clock_out"),
	                rs.getString("real_in"),
	                rs.getString("real_out")
	            );
	            shiftList.add(s);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        shiftList = null;
	    } finally {
	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
	    }

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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
//			SQL文を準備
			String sql = "INSERT INTO shift (user_id, date, clock_in, clock_out, real_in, real_out) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
//			SQL文を完成させる
			pStmt.setString(1, card.getUser_id());
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
	
	// 引数shiftで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Shift shift) {
	    Connection conn = null;
	    boolean result = false;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/mamoral?"
	            + "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
	            "root", "password");

	        // SQL文
	        String sql = "UPDATE shift SET date=?, clock_in=?, clock_out=?, real_in=?, real_out=? WHERE id=?";
	        PreparedStatement pStmt = conn.prepareStatement(sql);

	        pStmt.setString(1, shift.getDate());
	        pStmt.setString(2, shift.getClock_in());
	        pStmt.setString(3, shift.getClock_out());
	        pStmt.setString(4, shift.getReal_in());
	        pStmt.setString(5, shift.getReal_out());
	        pStmt.setInt(6, shift.getId());

	        if (pStmt.executeUpdate() == 1) {
	            result = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
	    }

	    return result;
	}

	// 引数shiftで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(Shift shift) {
	    Connection conn = null;
	    boolean result = false;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/mamoral?"
	            + "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
	            "root", "password");

	        String sql = "DELETE FROM shift WHERE id=?";
	        PreparedStatement pStmt = conn.prepareStatement(sql);

	        pStmt.setInt(1, shift.getId());

	        if (pStmt.executeUpdate() == 1) {
	            result = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
	    }

	    return result;
	}

//	出勤登録
	public boolean updateRealIn(Shift shift) {
	    Connection conn = null;
	    boolean result = false;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/mamoral?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
	            "root", "password");
	        
	        //日付を取得し変数をを格納
			Calendar cl = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			

			
	        // 現在時刻を取得（HH:mm:ss）
	        LocalTime now = LocalTime.now();
	        String time = now.toString();

	        String sql =
	            "UPDATE shift SET real_in = ? " +
	            "WHERE user_id = ? " +
	            "AND date = ?";

	        PreparedStatement ps = conn.prepareStatement(sql);
	        
	        //ps.setString(1, time);
	        //pStmt.setString(1, card.getUser_id());
	        //ps.setString(1, shift.getReal_in());
	        //ps.setString(2, shift.getUser_id());
	        //ps.setString(3, shift.getDate());
	        //ps.setString(1, user_id);
	        //ps.setString(2, date);
	        
	        if (time != null) {
 				ps.setString(1, time);
 			} else {
 				ps.setString(1, "");
 			}
	        if (shift.getUser_id() != null) {
 				ps.setString(2, shift.getUser_id());
 			} else {
 				ps.setString(2, "");
 			}
 			if (shift.getDate() == sdf.format(cl)) {
 				ps.setString(3, shift.getDate());
 			} else {
 				ps.setString(3, "");
 			}

	        if (ps.executeUpdate() == 1) {
	            result = true;
	        }
	        

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
	    }

	    return result;
	}

//	退勤登録
	public boolean updateRealOut(String userName, String date) {
	    Connection conn = null;
	    boolean result = false;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/mamoral?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
	            "root", "password");

	        LocalTime now = LocalTime.now();
	        String time = now.toString();

	        String sql =
	            "UPDATE shift SET real_out = ? " +
	            "WHERE user_id = (SELECT user_id FROM user WHERE user_name = ?) " +
	            "AND date = ?";

	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, time);
	        ps.setString(2, userName);
	        ps.setString(3, date);

	        if (ps.executeUpdate() == 1) {
	            result = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
	    }

	    return result;
	    
	}

}