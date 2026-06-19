package servlet;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PassDao;
import dto.User;



/**
 * Servlet implementation class Mypage_m_Servlet
 */
@WebServlet("/Mypage_m_Servlet")
public class Mypage_m_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	// doGet もしもログインしていなかったらログインサーブレットにリダイレクトする
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/c1/LoginServlet");
			return;
		}*/

		// マイページ（店長画面）のjspを読み込む
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage_m.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	// doPost もしもログインしていなかったらログインサーブレットにリダイレクトする
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/c1/LoginServlet");
			return;
		}*/		

		// マイページ（店長画面）のjspを読み込む
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage_m.jsp");
		dispatcher.forward(request, response);
	
	
		HttpSession session = request.getSession();
		
		// 文字化け防止
		request.setCharacterEncoding("UTF-8");

		// ここからpassword変更の箇所
		// フォームに入力された値を取得する
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
				
		//ログインしているユーザーuser_idをセッションスコープから取得
		String user_id = (String)session.getAttribute("user_id");
		
		// password変更の処理を行う。Trueなら上書きして変更する。falseは現在のパスワードが一致していない時に行われる
		PassDao bDao = new PassDao();
		if (request.getParameter("submit").equals("変更する")) {
			if (bDao.update(new User("","",password,0))) { // 更新成功
				request.setAttribute("result", new Result("更新成功！", "パスワードを新しく更新しました。", "/c1/Mypage_m_Servlet"));
			} else { // 更新失敗
				request.setAttribute("result", new Result("更新失敗！", "パスワードの更新ができませんでした。", "/c1/Mypage_m_Servlet"));
			}	
		}
		
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
		dispatcher.forward(request, response);
	}	
		
		//参考
		//BcDAO bDao = new BcDAO();
		//if (request.getParameter("submit").equals("更新")) {
			//if (bDao.update(new Bc(list_number,company,department,position,
			//	familly_name,first_name,familly_reading,first_reading,
			//	gender,post,address,main_phone,fax,phone,mail,memo))) { // 更新成功
			//	request.setAttribute("result", 
			//	new Result("更新成功！", "レコードを更新しました。", "/webapp/MenuServlet"));
		//	} else { // 更新失敗
			//	request.setAttribute("result", 
			//	new Result("更新失敗！", "レコードを更新できませんでした。", "/webapp/MenuServlet"));
			//}
		//} 
		
}
