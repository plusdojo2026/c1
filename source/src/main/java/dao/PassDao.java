// 6/23 12:11 backUp
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;

public class PassDao {

	String password ;
	String newPassword ;
	String user_id;

	
	public PassDao (String user_id,String password, String newPassword) {
		this.password = password;
		this.newPassword = newPassword;
		this.user_id = user_id;
	}
	
	
	
	// セッションスコープのuser_idを元に、現在のパスワードが一致しているか確認する
	public boolean select(User card) {
		Connection conn = null;
//System.out.println("L29");
//		List<User> cardList = new ArrayList<User>();
		boolean resultAns = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する　アップロードの際にコメントアウトをつける
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements"
					+ "=true","root", "password");

//			アップロードの際にコメントアウトを外す
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c1?"
//					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
//					"c1", "c3aXB3a6xd7ursUv");
			
			// SQL文を準備する
			// userテーブルからuser_id,passwordが該当するものを検索する。
			String sql = "SELECT user_id,password FROM user WHERE user_id = ? "
					+ "AND password = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,this.user_id);
			pStmt.setString(2,this.password);
//System.out.println(this.user_id);
//System.out.println(this.password);
//System.out.println(this.newPassword);
			
			// あっていれば(True)上書きをする。間違っているなら(false)更新しない
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
//System.out.println("L51");
			if (rs.next()) {
//System.out.println("L56");
				sql = "UPDATE user SET password = ? WHERE user_id = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(2,this.user_id);
				pStmt.setString(1,this.newPassword);
				
				
				if (pStmt.executeUpdate() == 1) {
//System.out.println("L60");
					resultAns =  true;
				}
			} else {
//System.out.println("L64");
				resultAns = false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
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
	return resultAns;
	}
}
	
/*	// 現在のパスワードに新しいパスワードを上書きする
	public boolean update(User card) {
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
			String sql = "UPDATE user SET password = ? WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			
			
			// SQL文を完成させる
			if (card.getPassword() != null) {
				pStmt.setString(1, card.getPassword());
			} else {
				pStmt.setString(1, "");
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
	
}*/
