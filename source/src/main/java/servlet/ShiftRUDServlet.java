package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShiftDao;
import dto.Shift;

@WebServlet("/ShiftRUDServlet")
public class ShiftRUDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String action = request.getParameter("action");  // insert / update / delete
        ShiftDao dao = new ShiftDao();
        boolean result = false;

        try {
            //登録処理
            if ("insert".equals(action)) {

                Shift shift = new Shift();
                shift.setUser_name(request.getParameter("user_name"));
                shift.setDate(request.getParameter("date"));
                shift.setClock_in(request.getParameter("clock_in"));
                shift.setClock_out(request.getParameter("clock_out"));

                result = dao.insert(shift);

                if (result) {
                    session.setAttribute("successMessage", "登録が完了しました。");
                } else {
                    session.setAttribute("errorMessage", "登録に失敗しました。");
                }

            //更新処理
            } else if ("update".equals(action)) {

                Shift shift = new Shift();
                shift.setId(Integer.parseInt(request.getParameter("id")));
                shift.setDate(request.getParameter("date"));
                shift.setClock_in(request.getParameter("clock_in"));
                shift.setClock_out(request.getParameter("clock_out"));
                shift.setReal_in(request.getParameter("real_in"));
                shift.setReal_out(request.getParameter("real_out"));

                result = dao.update(shift);

                if (result) {
                    session.setAttribute("successMessage", "更新が完了しました。");
                } else {
                    session.setAttribute("errorMessage", "更新に失敗しました。");
                }

            //削除処理
            } else if ("delete".equals(action)) {

                int id = Integer.parseInt(request.getParameter("id"));
                Shift shift = new Shift();
                shift.setId(id);

                result = dao.delete(shift);

                if (result) {
                    session.setAttribute("successMessage", "削除が完了しました。");
                } else {
                    session.setAttribute("errorMessage", "削除に失敗しました。");
                }
            }

        } catch (Exception e) {
            session.setAttribute("errorMessage", "処理中にエラーが発生しました。");
        }

        response.sendRedirect("/c1/ShiftServlet");
    }
}
