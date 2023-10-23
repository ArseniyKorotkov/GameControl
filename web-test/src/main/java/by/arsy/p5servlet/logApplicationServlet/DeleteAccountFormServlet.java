package by.arsy.p5servlet.logApplicationServlet;

import by.arsy.p1util.JspGuide;
import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete_account_form")
public class DeleteAccountFormServlet extends HttpServlet {

    private final UserService service = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("can_delete_users", service.findNamesCanDeleteUsers(user.getName()));
        req.getRequestDispatcher(JspGuide.to("log", "delete_account_form")).forward(req, resp);
    }
}
