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
 * Servlet implementation class RegistServlet
 */
@WebServlet("/BooksRegistServlet")
public class BooksRegistServlet extends HttpServlet {
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
		
		HttpSession session = request.getSession();
		
		String user_id  = (String)session.getAttribute("user_id");
		String date = request.getParameter("date");
		String category_id = request.getParameter("category_id");
		String title = request.getParameter("title");
		
		String teacher = (String)session.getAttribute("user_name");
		
		String manual = request.getParameter("manual");
		
		HttpSession session2 = request.getSession();
		String update_name  = (String)session2.getAttribute("user_name");
		String update_date = request.getParameter("update_date");

		// 登録処理を行う
		BooksDao bDao = new BooksDao();
		if (bDao.insert(new Books(0, user_id,"",category_id,title,teacher,
				manual,update_name,""))) { // 登録成功
			request.setAttribute("result", new Result("登録成功！", "レコードを登録しました。", "/c1/BooksServlet"));
		} else { // 登録失敗
			request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/c1/BooksServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
		dispatcher.forward(request, response);
	}
}
