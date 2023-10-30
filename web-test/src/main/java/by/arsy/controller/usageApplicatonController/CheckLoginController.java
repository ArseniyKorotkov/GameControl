package by.arsy.controller.usageApplicatonController;

import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@RequestMapping("/check_enter")
public class CheckLoginController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public String checkData(@RequestParam("userName") String name,
                            @RequestParam("userPass") String password,
                            HttpSession session) {
        name = name.trim();
        Optional<User> user = service.getUser(name, password);
        if (user.isEmpty()) {
            if (service.haveName(name)) {
                session.setAttribute("pass_statement", "Wrong password");
            } else {
                session.setAttribute("pass_statement", "No such account");
            }
            return "redirect:control";
        } else if (service.getConnectUsers().containsKey(user.get().getId())) {
            session.setAttribute("pass_statement", "Account is already used");
            return "redirect:control";
        } else {
            session.setAttribute("pass_statement", "Account is into system");
            session.setAttribute("user", user.get());
            service.addUserToConnect(user.get());
            return "redirect:menu";
        }
    }
}
