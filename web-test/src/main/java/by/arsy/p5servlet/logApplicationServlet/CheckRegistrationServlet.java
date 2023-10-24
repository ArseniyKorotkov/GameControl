package by.arsy.p5servlet.logApplicationServlet;

import by.arsy.p4service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
@RequestMapping("/check_regis")
public class CheckRegistrationServlet {

    private static final HashMap<String, String> REQUESTS_FOR_LOG = new HashMap<>();

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String checkRegistration(HttpServletRequest req) {
        String name = req.getParameter("userName").trim();
        String pass = req.getParameter("userPass");
        String answer;
        if (service.haveName(name)) {
            answer = "try another  name";
        } else {
            REQUESTS_FOR_LOG.put(name, pass);
            req.getSession().setAttribute("answer_for_request_log_boolean", true);
            req.getSession().setAttribute("registration_name", name);
            answer = "please, wait master`s answer";
        }
        req.getServletContext().setAttribute("logg_users", REQUESTS_FOR_LOG);
        req.getSession().setAttribute("answer_for_request_log", answer);
        return "redirect:registration_form";

    }
}
