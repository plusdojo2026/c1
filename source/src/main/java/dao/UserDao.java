package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import dto.User;

public class UserDao {
	// 引数で指定されたidpwでログイン成功ならtrueを返す
		public boolean isLoginOK(User user) {
			Connection conn = null;
			boolean loginResult = false;
			
			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
				
				// SELECT文を準備する
				String sql = "SELECT count(*) FROM user WHERE user_id=? AND password=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, user.getUserId());
				pStmt.setString(2, user.getPassword());
				//pStmt.setInt(3, user.getAuthorityId());
				
				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
				rs.next();
				if (rs.getInt("count(*)") == 1) {
					loginResult = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				loginResult = false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				loginResult = false;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						loginResult = false;
					}
				}
			}
			// 結果を返す
			return loginResult;
		}
		public User findByLogin(String userId, String password) { 
		    Connection conn = null;
		    User user = null;

		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");

		        conn = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/mamoral?"
		            + "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
		            "root", "password");

		        String sql = "SELECT user_id, user_name, authority_id FROM user WHERE user_id=? AND password=?";
		        PreparedStatement pStmt = conn.prepareStatement(sql);
		        pStmt.setString(1, userId);
		        pStmt.setString(2, password);

		        ResultSet rs = pStmt.executeQuery();
		        
		        if (rs.next()) {
		            user = new User(
		                rs.getString("user_id"),
		                rs.getString("user_name"),
		                null,         
		                rs.getInt("authority_id")  
		            );
		        }
		        
		     // データベースを切断
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try { if (conn != null)
		        	conn.close(); } 
		        catch (SQLException e) {}
		    }
		 // 結果を返す
		    return user;
		}   
}