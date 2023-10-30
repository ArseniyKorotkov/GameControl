package by.arsy.controller.logApplicationController;

import by.arsy.p2entity.User;
import by.arsy.p4service.ButtonService;
import by.arsy.p4service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping("/delete_account")
public class DeleteAccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private ButtonService buttonService;

    @RequestMapping(method = RequestMethod.POST)
    public String deleteAccount(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        ArrayList<String> findNamesCanDeleteUsers = userService.findNamesCanDeleteUsers(user.getName());
        for (String name : findNamesCanDeleteUsers) {
            if (req.getParameter(name + "_delete_account") != null) {
                buttonService.deleteConsoleValuesFor(userService.getIdByName(name));
                userService.deleteUserByName(name);
            }
        }

        return "redirect:delete_account_form";
    }
}
