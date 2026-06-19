package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Books;

public class BooksDao {
	// 引数card指定された項目で検索して、取得されたデータのリストを返す
	public List<Books> select(Books card) {
		Connection conn = null;
		List<Books> cardList = new ArrayList<Books>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamoral?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM Books "
					+ "WHERE "
					+ "user_id LIKE ? AND "
					+ "date LIKE ? AND "
					+ "category_id LIKE ? AND "
					+ "title LIKE ? AND "
					+ "teacher LIKE ? AND "
					+ "manual LIKE ? AND "
					+ "update_name LIKE ? AND "
					+ "update_date LIKE ? "
					+ "ORDER BY title ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_id() != null) {
				pStmt.setString(1, "%" + card.getUser_id() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (card.getDate() != null) {
				pStmt.setString(2, "%" + card.getDate() + "%");
			} else {
				pStmt.setString(2, "%");
			}
			if (card.getCategory_id() != 0) {
				pStmt.setInt(3, 0 + card.getCategory_id() + 0);
			} else {
				pStmt.setInt(3, 0);
			}
			if (card.getTitle() != null) {
				pStmt.setString(4, "%" + card.getTitle() + "%");
			} else {
				pStmt.setString(4, "%");
			}
			if (card.getTeacher() != null) {
				pStmt.setString(5, "%" + card.getTeacher() + "%");
			} else {
				pStmt.setString(5, "%");
			}
			if (card.getManual() != null) {
				pStmt.setString(6, "%" + card.getManual() + "%");
			} else {
				pStmt.setString(6, "%");
			}
			if (card.getUpdate_name() != null) {
				pStmt.setString(7, "%" + card.getUpdate_name() + "%");
			} else {
				pStmt.setString(7, "%");
			}
			if (card.getUpdate_date() != null) {
				pStmt.setString(8, "%" + card.getUpdate_date() + "%");
			} else {
				pStmt.setString(8, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Books books = new Books(rs.getInt("id"),rs.getString("user_id"), rs.getString("date"),  rs.getInt("category_id"), rs.getString("title"),rs.getString("teacher"),
						rs.getString("manual"),rs.getString("update_name"),rs.getString("update_date") );
				cardList.add(books);
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
	public boolean insert(Books card) {
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
			String sql = "INSERT INTO Books VALUES (0, ?,?,?,?,?,?,?,?)";
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
			if (card.getCategory_id() != 0) {
				pStmt.setInt(3, card.getCategory_id());
			} else {
				pStmt.setInt(3, 0);
			}
			if (card.getTitle() != null) {
				pStmt.setString(4, card.getTitle());
			} else {
				pStmt.setString(4, "");
			}
			if (card.getTeacher() != null) {
				pStmt.setString(5, card.getTeacher());
			} else {
				pStmt.setString(5, "");
			}
			if (card.getManual() != null) {
				pStmt.setString(6, card.getManual());
			} else {
				pStmt.setString(6, "");
			}
			if (card.getUpdate_name() != null) {
				pStmt.setString(7, card.getUpdate_name());
			} else {
				pStmt.setString(7, "");
			}
			if (card.getUpdate_date() != null) {
				pStmt.setString(8, card.getUpdate_date());
			} else {
				pStmt.setString(8, "");
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
	public boolean update(Books card) {
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
			String sql = "UPDATE Books SET user_id =?, date =?, category_id =?, title =?, teacher =?, manual =?, update_name =?, update_date =? WHERE id=?";
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
			if (card.getCategory_id() != 0) {
				pStmt.setInt(3, card.getCategory_id());
			} else {
				pStmt.setInt(3, 0);
			}
			if (card.getTitle() != null) {
				pStmt.setString(4, card.getTitle());
			} else {
				pStmt.setString(4, "");
			}
			if (card.getTeacher() != null) {
				pStmt.setString(5, card.getTeacher());
			} else {
				pStmt.setString(5, "");
			}
			if (card.getManual() != null) {
				pStmt.setString(6, card.getManual());
			} else {
				pStmt.setString(6, "");
			}
			if (card.getUpdate_name() != null) {
				pStmt.setString(7, card.getUpdate_name());
			} else {
				pStmt.setString(7, "");
			}
			if (card.getUpdate_date() != null) {
				pStmt.setString(8, card.getUpdate_date());
			} else {
				pStmt.setString(8, "");
			}
	
			pStmt.setInt(9, card.getId());

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
	public boolean delete(Books card) {
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
			String sql = "DELETE FROM Books WHERE id=?";
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
