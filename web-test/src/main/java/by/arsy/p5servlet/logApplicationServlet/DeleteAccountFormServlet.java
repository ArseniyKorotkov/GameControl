package by.arsy.p5servlet.logApplicationServlet;

import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/delete_account_form")
public class DeleteAccountFormServlet {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String goToPost(HttpServletRequest req) {
        return goToForm(req);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String goToForm(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("can_delete_users", service.findNamesCanDeleteUsers(user.getName()));
        return "log/delete_account_form";
    }
}
