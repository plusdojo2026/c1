package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SuggestionDao;
import dto.Result;
import dto.Suggestion;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/c1/LoginServlet");
			return;
		}

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
	
		String user_id = (String)session.getAttribute("user_id");
//		String user_id = "yamada-yuki-m";
		String suggestion = request.getParameter("suggestion");	
		
//		/WEB-INF/jsp/HomeResult.jsp
		
		// 登録処理を行う
		SuggestionDao sDao = new SuggestionDao();
		if (sDao.insert(new Suggestion(0, user_id, "", suggestion))) { // 送信成功
			request.setAttribute ("result", new Result("送信成功！", "ご意見を送信しました。", request.getContextPath() + "/HomeServlet"));
			} else { // 送信失敗
			request.setAttribute ("result", new Result("送信失敗！", "ご意見を送信できませんでした。", request.getContextPath() + "/HomeServlet"));
		}

		// ホーム画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/HomeResult.jsp");
		dispatcher.forward(request, response);
		}
	}
