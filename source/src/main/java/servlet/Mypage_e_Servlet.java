package servlet;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

/**
 * Servlet implementation class Mypage_e_Servlet
 */
@WebServlet("/Mypage_e_Servlet")
public class Mypage_e_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/c1/LoginServlet");
			return;
		}*/

		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage_e.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/c1/LoginServlet");
			return;
		}*/

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id  = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		int authority_id = Integer.parseInt(request.getParameter("authority_id"));
		
		// 登録処理を行う
		UserDao bDao = new UserDao();
		if (bDao.insert(new User(user_id,user_name,password,0))) { // 登録成功
					request.setAttribute("result", 
					new Result("パスワードを更新しました！"));
		} else { // 登録失敗
			request.setAttribute("result", 
			new Result("パスワードを更新できませんでした。"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage_e.jsp");
		dispatcher.forward(request, response);
	}
}
