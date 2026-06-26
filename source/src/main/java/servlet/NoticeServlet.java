package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;
import dto.Notice;

/**
 * Servlet implementation class NoticesServlet
 */
@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
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

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id  = request.getParameter("user_id");
		String user_name = null;
		String date= request.getParameter("date");
		String title = request.getParameter("title");
		String notice = request.getParameter("notice");
		String update_name = request.getParameter("update_name");
		String update_date = request.getParameter("update_date");
		
		// 検索処理を行う
		NoticeDao bDao = new NoticeDao();
		List<Notice> cardList = bDao.select(new Notice(0, user_id,user_name,date,title,notice,update_name,update_date));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
		
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Notice.jsp");
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
		String user_name  = request.getParameter("user_name");
	System.out.println("☆☆" + user_name);
		String date= request.getParameter("date");
		String title = request.getParameter("title");
		String notice = request.getParameter("notice");
		String update_name = request.getParameter("update_name");
		String update_date = request.getParameter("update_date");
		
		// 検索処理を行う
		NoticeDao bDao = new NoticeDao();
		List<Notice> cardList = bDao.select(new Notice(0, user_id,user_name,date,title,notice,update_name,update_date));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Notice.jsp");
		dispatcher.forward(request, response);
	}
}