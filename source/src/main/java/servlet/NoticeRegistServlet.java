package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticeDao;
import dto.Notice;

/**
 * Servlet implementation class NoticeRegistServlet
 */
@WebServlet("/NoticeRegistServlet")
public class NoticeRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/webapp/NoticeServlet");
			return;
		}*/

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NoticeRegist.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/java/LoginServlet");
			return;
		}
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_id  = request.getParameter("user_id");
				String registTitle = request.getParameter("registTitle");
				String date = request.getParameter("date");
				String registText = request.getParameter("registText");
		
				// 登録処理を行う
				NoticeDao bDao = new NoticeDao();
				if (bDao.insert(new Notice(0, user_id,registTitle,date,registText))) { // 登録成功
					request.setAttribute("result", new Result("登録成功！", "レコードを登録しました。", "/c1/NoticeServlet"));
				} else { // 登録失敗
					request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/c1/NoticeServlet"));
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
				dispatcher.forward(request, response);
			}
		}
