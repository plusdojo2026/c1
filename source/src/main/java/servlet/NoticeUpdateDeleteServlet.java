package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;
import dto.Notice;
import dto.Result;

/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/NoticeUpdateDeleteServlet")
public class NoticeUpdateDeleteServlet extends HttpServlet {
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
		String user_id  = request.getParameter("user_id");
		String registTitle = request.getParameter("registTitle");
		String date = request.getParameter("date");
		String registText = request.getParameter("registText");

		// 更新または削除を行う
		NoticeDao bDao = new NoticeDao();
		if (request.getParameter("submit").equals("更新")) {
			if (bDao.insert(new Notice(0, user_id,registTitle,date,registText))) { // 更新成功
				request.setAttribute("result", new Result("更新成功！", "レコードを更新しました。", "/c1/NoticeServlet"));
			} else { // 更新失敗
				request.setAttribute("result", new Result("更新失敗！", "レコードを更新できませんでした。", "/c1/NoticeServlet"));
			}
		} else {
			if (bDao.delete(new Notice(0, user_id,registTitle,date,registText))) { // 削除成功
				request.setAttribute("result", new Result("削除成功！", "レコードを削除しました。", "/c1/NoticeServlet"));
			} else { // 削除失敗
				request.setAttribute("result", new Result("削除失敗！", "レコードを削除できませんでした。", "/c1/NoticeServlet"));
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
		dispatcher.forward(request, response);
	}
}
