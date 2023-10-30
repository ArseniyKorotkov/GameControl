package by.arsy.controller.logApplicationController;

import by.arsy.p2dto.LoginAttributesDto;
import by.arsy.p4service.UserService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping("/registration_form")
public class RegistrationController {

    private static final String GOOD_ANSWER = "Registration approved ✅  " +
                                              "You can log in to the system ";

    private static final String BAD_ANSWER = "Registration canceled ❌";

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String registration(HttpSession session,
                               Model model) {
        Optional<Object> registrationName = Optional.ofNullable(session.getAttribute("registration_name"));
        Object loggUsersObject = servletContext.getAttribute("logg_users");
        HashMap<String, String> loggUsers = (HashMap<String, String>) loggUsersObject;
        if (registrationName.isPresent() && loggUsers != null) {
            if (service.haveName(String.valueOf(registrationName.get()))) {
                session.setAttribute("answer_for_request_log", GOOD_ANSWER);
            } else if (!loggUsers.containsKey(registrationName.get().toString())) {
                session.setAttribute("answer_for_request_log", BAD_ANSWER);
            }
            model.addAttribute("verdict", true);

        }
        model.addAttribute("loginAttributesDto", new LoginAttributesDto());
        return "log/registration_form";
    }
}
