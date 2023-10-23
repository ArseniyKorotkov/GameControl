package by.arsy.p5servlet.usageApplicatonServlet;

import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/check_enter")
public class CheckEnterServlet extends HttpServlet {

    private final UserService service = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("userName").trim();
        String password = req.getParameter("userPass");
        Optional<User> user = service.getUser(name, password);
        if (user.isEmpty()) {
            if (service.haveName(name)) {
                session.setAttribute("pass_statement", "Wrong password");
            } else {
                session.setAttribute("pass_statement", "No such account");
            }
            resp.sendRedirect("control");
        } else if (service.getConnectUsers().containsKey(user.get().getId())) {
            session.setAttribute("pass_statement", "Account is already used");
            resp.sendRedirect("control");
        } else {
            session.setAttribute("pass_statement", "Account is into system");
            session.setAttribute("user", user.get());
            service.addUserToConnect(user.get());
            resp.sendRedirect("menu");
        }
    }
}
