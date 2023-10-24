package by.arsy.p5servlet.logApplicationServlet;

import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import by.arsy.p7coder.HashCoder;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/change_pass")
public class PasswordChangerServlet extends HttpServlet {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String changePasswordPage() {
        return "log/change_password";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String changePassword(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        String oldPass = req.getParameter("old_pass");
        String newPass = req.getParameter("new_pass");
        String repeatPass = req.getParameter("repeat_pass");

        if (service.getUser(user.getName(), oldPass).isPresent()) {
            if (newPass.equals(repeatPass)) {
                service.changePass(user.getName(), HashCoder.getHash(newPass));
                req.setAttribute("answer_change", "change is OK");
            } else {
                req.setAttribute("answer_change", "wrong repeat password");
            }
        } else {
            req.setAttribute("answer_change", "wrong password");
        }
        return "log/change_password";
    }

}
