package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShiftDao;
import dto.Shift;

@WebServlet("/ShiftServlet")
public class ShiftServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        HttpSession session = request.getSession(false);
    	HttpSession session = request.getSession();
    	
		String user_id = (String)session.getAttribute("user_id");
		int authority_id = (int) session.getAttribute("authority_id");
        //ログインしていない場合
        if (session == null || session.getAttribute("user_id") == null) {
            response.sendRedirect("/c1/LoginServlet");
            return;
        }

        // 検索条件
        String word = request.getParameter("word");
        String year = request.getParameter("year");
        String month = request.getParameter("month");

        // DTO
        Shift condition = new Shift();
        if (authority_id == 2) {
            condition.setUser_id(user_id);
        }
        condition.setWord(word);
        condition.setYear(year);
        condition.setMonth(month);

        // DAO呼び出し
        ShiftDao dao = new ShiftDao();
        List<Shift> list = dao.select(condition);

        request.setAttribute("shiftList", list);

        // 権限で画面分岐

        if (authority_id == 1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Shift_m.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Shift_e.jsp");
            dispatcher.forward(request, response);
        }
    }
}
