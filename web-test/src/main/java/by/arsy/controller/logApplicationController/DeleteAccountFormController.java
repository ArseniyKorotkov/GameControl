package by.arsy.controller.logApplicationController;

import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/delete_account_form")
public class DeleteAccountFormController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String goToPost(HttpSession session,
                           Model model) {

        return goToForm(session, model);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String goToForm(HttpSession session,
                           Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("can_delete_users", service.findNamesCanDeleteUsers(user.getName()));
        return "log/delete_account_form";
    }
}
