package by.arsy.p5servlet.usageApplicatonController;

import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Optional;


@Controller
@RequestMapping("/check_enter")
public class CheckEnterController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public String checkData(HttpServletRequest req) {
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
