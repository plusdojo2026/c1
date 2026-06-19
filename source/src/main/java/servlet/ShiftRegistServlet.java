package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Shift;
import dto.Result;

@WebServlet("/ShiftRegistServlet")
public class ShiftRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	// リクエストパラメータを取得する
	request.setCharacterEncoding("UTF-8");
	String id  = request.getParameter("id");
	String user_name = request.getParameter("user_name");
	String date = request.getParameter("date");
	String clock_in = request.getParameter("clock_in");
	String clock_out = request.getParameter("clock_out");
	String real_in = request.getParameter("real_in");
	String real_out = request.getParameter("real_out");


	// 登録処理を行う
	ShiftDao sDao = new ShiftDao();
	if (bDao.insert(new Books(0,user_name,date,clock_in,clock_out,
			real_in,real_out ))) { // 登録成功
		request.setAttribute("result", new Result("登録成功！", "レコードを登録しました。", "/c1/ShiftServlet"));
	} else { // 登録失敗
		request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/c1/ShiftServlet"));
	}

	// 結果ページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ShiftResult.jsp");
	dispatcher.forward(request, response);
}