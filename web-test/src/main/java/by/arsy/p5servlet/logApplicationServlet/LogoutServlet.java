package by.arsy.p5servlet.logApplicationServlet;

import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class LogoutServlet {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        service.logoutUser((User) session.getAttribute("user"));
        req.getSession().invalidate();
        return "redirect:control";
    }
}
