package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShiftServlet")
public class ShiftServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // ログインしていない場合
        if (session == null || session.getAttribute("user_id") == null) {
            response.sendRedirect("/c1/LoginServlet");
            return;
        }

        
        int authority = (int) session.getAttribute("authority");

       
        if (authority == 1) {
            // 店長
            request.getRequestDispatcher("Shift_m.jsp").forward(request, response);
        } else if (authority == 2) {
            // 従業員
            request.getRequestDispatcher("Shift_e.jsp").forward(request, response);
        } 
    }
}
