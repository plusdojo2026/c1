package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dto.Notice;

public class NoticeDao {
	// 引数card指定された項目で検索して、取得されたデータのリストを返す
	public List<Notice> select(Notice card) {
		Connection conn = null;
		List<Notice> cardList = new ArrayList<Notice>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する　アップロードの際にコメントアウトをつける
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
//				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
//					"root", "password");
			
			//アップロードの際にコメントアウトを外す
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"c1", "c3aXB3a6xd7ursUv");

			// SQL文を準備する
			String sql = "SELECT * FROM notice "
					+ "WHERE "
					+ "user_id LIKE ? AND "
					+ "user_name LIKE ? AND "
					+ "date LIKE ? AND "
					+ "title LIKE ? AND "			
					+ "notice LIKE ? AND "
					+ "update_name LIKE ? AND "
					+ "update_date LIKE ? ";
//					+ "update_date LIKE ? AND "
//					+ "ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_id() != null) {
				pStmt.setString(1, "%" + card.getUser_id() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (card.getUser_name() != null) {
				pStmt.setString(2, "%" + card.getUser_name() + "%");
			} else {
				pStmt.setString(2, "%");
			}
System.out.println("★★" + card.getUser_name());
			if (card.getDate() != null) {
				pStmt.setString(3, "%" + card.getDate() + "%");
			} else {
				pStmt.setString(3, "%");
			}
			
			if (card.getTitle() != null) {
				pStmt.setString(4, "%" + card.getTitle() + "%");
			} else {
				pStmt.setString(4, "%");
			}
			if (card.getNotice() != null) {
				pStmt.setString(5, "%" + card.getNotice() + "%");
			} else {
				pStmt.setString(5, "%");
			}
			if (card.getUpdate_name() != null) {
				pStmt.setString(6, "%" + card.getUpdate_name() + "%");
			} else {
				pStmt.setString(6, "%");
			}
			if (card.getUpdate_date() != null) {
				pStmt.setString(7, "%" + card.getUpdate_date() + "%");
			} else {
				pStmt.setString(7, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
System.out.println(rs.getString("user_name"));
				Notice Notice = new Notice(rs.getInt("id"),rs.getString("user_id"), rs.getString("user_name"), rs.getString("date"),
						rs.getString("title"),rs.getString("notice"),rs.getString("update_name"),rs.getString("update_date"));
				cardList.add(Notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Notice card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む　アップロードの際にコメントアウトをつける
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する　アップロードの際にコメントアウトをつける
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
//					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
//					"root", "password");
			
//			アップロードの際にコメントアウトを外す
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"c1", "c3aXB3a6xd7ursUv");
			
			//日付を取得し変数を格納
			Calendar cl = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// SQL文を準備する
			String sql = "INSERT INTO notice VALUES (0, ?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_id() != null) {
				pStmt.setString(1, card.getUser_id());
			} else {
				pStmt.setString(1, "");
			}
			
			sql = "select user_name from user where user_id = \"" + card.getUser_id() + "\"";
			PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

           // 取得した結果を1行ずつ処理
            String user_name = null;
           if (rs.next()) {
               user_name = rs.getString("user_name");
               pStmt.setString(2, user_name);
           } else {
				pStmt.setString(2, "");
           }
			
			if (card.getDate() != null) {
				pStmt.setString(3, sdf.format(cl.getTime()));
			} else {
				pStmt.setString(3, "");
			}
			if (card.getTitle() != null) {
				pStmt.setString(4, card.getTitle());
			} else {
				pStmt.setString(4, "");
			}
			
			if (card.getNotice() != null) {
				pStmt.setString(5, card.getNotice());
			} else {
				pStmt.setString(5, "");
			}
			if (card.getUpdate_name() != null) {
				pStmt.setString(6, card.getUpdate_name());
			} else {
				pStmt.setString(6, "");
			}
			if (card.getUpdate_date() != null) {
				pStmt.setString(7, sdf.format(cl.getTime()));
			} else {
				pStmt.setString(7, "");
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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Notice card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する　アップロードの際にコメントアウトをつける
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
//					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
//					"root", "password");
			
//			アップロードの際にコメントアウトを外す
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"c1", "c3aXB3a6xd7ursUv");
			
			// 日付を取得し変数をを格納
			Calendar cl = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// SQL文を準備する
			String sql = "UPDATE notice SET user_id=?, date=?, title=?, notice=?, update_name=?, update_date=? WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (card.getUser_id() != null) {
				pStmt.setString(1, card.getUser_id());
			} else {
				pStmt.setString(1, "");
			}
			if (card.getDate() != null) {
				pStmt.setString(2, card.getDate());
			} else {
				pStmt.setString(2, "");
			}
			if (card.getTitle() != null) {
				pStmt.setString(3, card.getTitle());
			} else {
				pStmt.setString(3, "");
			}
			if (card.getNotice() != null) {
				pStmt.setString(4, card.getNotice());
			} else {
				pStmt.setString(4, "");
			}
			if (card.getUpdate_name() != null) {
				pStmt.setString(5, card.getUpdate_name());
			} else {
				pStmt.setString(5, "");
			}
			if (card.getUpdate_date() == null || card.getUpdate_date().isEmpty()) {
	            pStmt.setString(6, sdf.format(cl.getTime()));
	        } else {
	            pStmt.setString(6, card.getUpdate_date());
	        }

	        pStmt.setInt(7, card.getId());

	        if (pStmt.executeUpdate() == 1) {
	            result = true;
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

	// 引数cardで指定された番号のレコードを削除し、成功したらtrueを返す
	public boolean delete(Notice card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する　アップロードの際にコメントアウトをつける
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
//					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
//					"root", "password");
			
//			アップロードの際にコメントアウトを外す
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c1?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"c1", "c3aXB3a6xd7ursUv");

			// SQL文を準備する
			String sql = "DELETE FROM Notice WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, card.getId());

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
