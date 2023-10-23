package by.arsy.p5servlet.logApplicationServlet;

import by.arsy.p4service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/check_regis")
public class CheckRegistrationServlet extends HttpServlet {

    private final UserService service = UserService.getInstance();
    private static final HashMap<String, String> REQUESTS_FOR_LOG = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName").trim();
        String pass = req.getParameter("userPass");
        String answer;
        if(service.haveName(name)) {
            answer = "try another  name";
        } else {
            REQUESTS_FOR_LOG.put(name, pass);
            req.getSession().setAttribute("answer_for_request_log_boolean", true);
            req.getSession().setAttribute("registration_name", name);
            answer = "please, wait master`s answer";
        }
        req.getServletContext().setAttribute("logg_users", REQUESTS_FOR_LOG);
        req.getSession().setAttribute("answer_for_request_log", answer);
        resp.sendRedirect("registration_form");

    }
}
