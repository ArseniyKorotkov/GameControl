package by.arsy.p5servlet.logApplicationServlet;

import by.arsy.p4service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping("/registration_form")
public class RegistrationServlet {

    private static final String GOOD_ANSWER = "Registration approved ✅  " +
                                              "You can log in to the system ";

    private static final String BAD_ANSWER = "Registration canceled ❌";

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String registration(HttpServletRequest req) {
        Optional<Object> registrationName = Optional.ofNullable(req.getSession().getAttribute("registration_name"));
        Object o = req.getServletContext().getAttribute("logg_users");
        HashMap<String, String> loggUsers = (HashMap<String, String>) req.getServletContext().getAttribute("logg_users");
        if (registrationName.isPresent() && loggUsers != null) {
            if (service.haveName(String.valueOf(registrationName.get()))) {
                req.getSession().setAttribute("answer_for_request_log", GOOD_ANSWER);
                req.setAttribute("verdict", true);
            } else if (!loggUsers.containsKey(registrationName.get().toString())) {
                req.getSession().setAttribute("answer_for_request_log", BAD_ANSWER);
                req.setAttribute("verdict", true);
            }

        }
        return "log/registration_form";
    }
}
