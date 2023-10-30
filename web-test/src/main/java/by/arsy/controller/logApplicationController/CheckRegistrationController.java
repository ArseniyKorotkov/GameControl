package by.arsy.controller.logApplicationController;

import by.arsy.p2dto.LoginAttributesDto;
import by.arsy.p4service.UserService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
@RequestMapping("/check_regis")
public class CheckRegistrationController {

    private static final HashMap<String, String> REQUESTS_FOR_LOG = new HashMap<>();
    public static final String GOOD_ANSWER = "please, wait master`s answer";
    public static final String BAD_ANSWER = "try another name";

    @Autowired
    private UserService service;
    @Autowired
    private ServletContext servletContext;

    @RequestMapping(method = RequestMethod.POST)
    public String checkRegistration(@ModelAttribute @Valid LoginAttributesDto loginAttributesDto,
                                    BindingResult bindingResult,
                                    HttpSession session,
                                    Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("loginAttributesDto", loginAttributesDto);
            return "log/registration_form";
        }

        String name = loginAttributesDto.getUserName().trim();
        String answer;
        if (service.haveName(name)) {
            answer = BAD_ANSWER;
        } else {
            REQUESTS_FOR_LOG.put(name, loginAttributesDto.getPassword());
            session.setAttribute("answer_for_request_log_boolean", true);
            session.setAttribute("registration_name", name);
            answer = GOOD_ANSWER;
        }
        servletContext.setAttribute("logg_users", REQUESTS_FOR_LOG);
        session.setAttribute("answer_for_request_log", answer);
        return "redirect:registration_form";
    }
}
