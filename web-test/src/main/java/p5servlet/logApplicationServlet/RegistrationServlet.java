package p5servlet.logApplicationServlet;

import by.arsy.p1util.JspGuide;
import by.arsy.p4service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@WebServlet("/registration_form")
public class RegistrationServlet extends HttpServlet {

    private static final String GOOD_ANSWER = "Registration approved ✅  " +
                                              "You can log in to the system ";

    private static final String BAD_ANSWER = "Registration canceled ❌";

    private final UserService service = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Object> registrationName = Optional.ofNullable(req.getSession().getAttribute("registration_name"));
        Object o =  req.getServletContext().getAttribute("logg_users");
        HashMap<String, String> loggUsers = (HashMap<String, String>) req.getServletContext().getAttribute("logg_users");
        if (registrationName.isPresent() && loggUsers != null) {
            if (service.haveName(String.valueOf(registrationName.get()))) {
                req.getSession().setAttribute("answer_for_request_log", GOOD_ANSWER);
                req.setAttribute("verdict", true);
            } else if(!loggUsers.containsKey(registrationName.get().toString())) {
                req.getSession().setAttribute("answer_for_request_log", BAD_ANSWER);
                req.setAttribute("verdict", true);
            }

        }
        req.getRequestDispatcher(JspGuide.to("log", "registration_form")).forward(req, resp);
    }
}
