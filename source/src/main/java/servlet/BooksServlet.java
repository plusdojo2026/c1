package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BooksDao;
import dto.Books;

/**
 * Servlet implementation class BooksServlet
 */
@WebServlet("/BooksServlet")
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/**
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/c1/LoginServlet");
			return;
		}
	*/

		// 検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Books.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/**
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/c1/LoginServlet");
			return;
		}
		*/

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id  = request.getParameter("user_id");
		String date = request.getParameter("date");
		String category_id = request.getParameter("category_id");
		String title = request.getParameter("title");
		String teacher = request.getParameter("teacher");
		String manual = request.getParameter("manual");
		String update_name = request.getParameter("update_name");
		String update_date = request.getParameter("update_date");

		// 検索処理を行う
		BooksDao bDao = new BooksDao();
		List<Books> cardList = bDao.select(new Books(0, user_id,date,0,title,teacher,
				manual,update_name,update_date));
		
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
		
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Books.jsp");
		dispatcher.forward(request, response);
	}
}