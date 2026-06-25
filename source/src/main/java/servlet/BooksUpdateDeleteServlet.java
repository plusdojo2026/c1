package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BooksDao;
import dto.Books;
import dto.Result;

/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/BooksUpdateDeleteServlet")
public class BooksUpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/c1/LoginServlet");
			return;
		}*/

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String user_id  = request.getParameter("user_id");
		String date = request.getParameter("date");
		String category_id = request.getParameter("category_id");
		String title = request.getParameter("title");
		String teacher = request.getParameter("teacher");
		String manual = request.getParameter("manual");
		HttpSession session = request.getSession();
		String update_name  = (String)session.getAttribute("user_name");
		String update_date = request.getParameter("update_date");

		// 更新または削除を行う
		BooksDao bDao = new BooksDao();
		if (request.getParameter("submit").equals("更新")) {
			if (bDao.update(new Books(id, user_id,date,category_id,title,teacher,
					manual,update_name,""))) { // 更新成功
				request.setAttribute("result", new Result("更新成功！", "レコードを更新しました。", "/c1/BooksServlet"));
			} else { // 更新失敗
				request.setAttribute("result", new Result("更新失敗！", "レコードを更新できませんでした。", "/c1/BooksServlet"));
			}
		} else {
			if (bDao.delete(new Books(id, user_id,date,category_id,title,teacher,
					manual,update_name,update_date))) { // 削除成功
				request.setAttribute("result", new Result("削除成功！", "レコードを削除しました。", "/c1/BooksServlet"));
			} else { // 削除失敗
				request.setAttribute("result", new Result("削除失敗！", "レコードを削除できませんでした。", "/c1/BooksServlet"));
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
		dispatcher.forward(request, response);
	}
}
