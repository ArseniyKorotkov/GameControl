package by.arsy.p5servlet.usageApplicatonController.menuContent;

import by.arsy.p4service.ButtonService;
import by.arsy.p4service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/console_settings")
public class ConsoleSettingsController {

    @Autowired
    private UserService userService = new UserService();
    @Autowired
    private final ButtonService buttonService = new ButtonService();

    @RequestMapping(method = RequestMethod.GET)
    protected String setConsoleValues(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/settings_button").include(req,resp);
        req.setAttribute("keyboard_buttons", buttonService.getKeyboardButtonsArray());
        req.setAttribute("connect_users", userService.getConnectUsers());

        return "usage/console_settings";
    }

}
