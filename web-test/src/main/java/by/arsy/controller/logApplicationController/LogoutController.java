package by.arsy.controller.logApplicationController;

import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public String logout(HttpSession session) {
        service.logoutUser((User) session.getAttribute("user"));
        session.invalidate();
        return "redirect:control";
    }
}
