package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PassDao;
import dto.ResultPage;
import dto.User;


/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	// doGet もしもログインしていなかったらログインサーブレットにリダイレクトする
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			HttpSession session = request.getSession();
			if (session == null || session.getAttribute("user_id") == null) {
				response.sendRedirect("/c1/LoginServlet");
				return;
			}

			// 権限を取得して画面表示を切り替える
//			HttpSession session = request.getSession();
			int authority = (int) session.getAttribute("authority_id");
			
			if (authority == 1) {
		      RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/Mypage_m.jsp");
		      disp.forward(request, response);
		  } else {
		      RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/Mypage_e.jsp");
		      disp.forward(request, response);
		  }

		
//		HttpSession session = request.getSession();
//		if (session == null || session.getAttribute("user_id") == null) {
//			response.sendRedirect("/c1/LoginServlet");
//			return;
//		}

//		// マイページ（店長画面）のjspを読み込む
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mypage_m.jsp");
//		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	// doPost もしもログインしていなかったらログインサーブレットにリダイレクトする
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("user_id") == null) {
			response.sendRedirect("/c1/LoginServlet");
			return;
		}	
	
		
		// 文字化け防止
		request.setCharacterEncoding("UTF-8");

		// ここからpassword変更の箇所
		// フォームに入力された値を取得する
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
				
		// ログインしているユーザーuser_idをセッションスコープから取得
		String user_id = (String)session.getAttribute("user_id");
		//String user_id = "yamada-yuki-m";【テスト】
		
		
		// password変更の処理を行う。Trueなら上書きして変更する。falseは現在のパスワードが一致していない時に行われる
		PassDao bDao = new PassDao(user_id,password,newPassword);
		//if (request.getParameter("submit").equals("変更する")) {
			if (bDao.select(new User("","",password,0))) { // 更新成功
				request.setAttribute("result", new ResultPage("登録成功！", "レコードを登録しました。", "/c1/MypageServlet"));
			} else { // 登録失敗
				request.setAttribute("result", new ResultPage("登録失敗！", "レコードを登録できませんでした。", "/c1/MypageServlet"));
			}
		
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
		dispatcher.forward(request, response);
		//}	
		
		
//		// 権限を取得して画面表示を切り替える
//        int authority = (int) session.getAttribute("authority_id");
//		
//		if (authority == 1) {
//            RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/Mypage_m.jsp");
//            disp.forward(request, response);
//        } else {
//            RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/Mypage_e.jsp");
//            disp.forward(request, response);
//        }
		
		
	}
	
	
}
