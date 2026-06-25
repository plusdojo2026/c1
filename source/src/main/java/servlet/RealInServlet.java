package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShiftDao;
import dto.Result;
import dto.Shift;

/**
 * Servlet implementation class RealInServlet
 */
@WebServlet("/RealInServlet")
public class RealInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	request.setCharacterEncoding("UTF-8");
	
	HttpSession session = request.getSession();
	String user_id = (String)session.getAttribute("user_id");
	
	//日付を取得し変数をを格納
	Calendar cl = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(cl.getTime());
	
	
	//現在日時を測る
	
	//現在日付とシフトの日付を比較する
	
	// 更新処理を行う
	ShiftDao shiftDao = new ShiftDao();
	if (shiftDao.RealInSelect(new Shift(0, user_id, "", date, "", "", "", ""))) { // 送信成功
		request.setAttribute ("result", new Result("出勤完了！", "今日も1日頑張りましょう！", request.getContextPath() + "/HomeServlet"));
		} else { // 送信失敗
		request.setAttribute ("result", new Result("出勤失敗！", "今日は休みです。", request.getContextPath() + "/HomeServlet"));
	}

	// ホーム画面にフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/HomeResult.jsp");
	dispatcher.forward(request, response);
	}
}
