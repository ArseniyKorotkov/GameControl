package by.arsy.controller.usageApplicatonController.menuContent;

import by.arsy.p2dto.ControlButtonDto;
import by.arsy.p4service.ButtonService;
import by.arsy.p4service.UserService;
import by.arsy.p7coder.ButtonNameCoder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/console_settings")
public class ConsoleSettingsController {

    @Autowired
    private UserService userService;
    @Autowired
    private ButtonService buttonService;

    @RequestMapping(method = RequestMethod.GET)
    protected String setConsoleValues(HttpServletRequest req,
                                      HttpServletResponse resp,
                                      Model model) throws ServletException, IOException {
        req.getRequestDispatcher("/settings_button").include(req,resp);

        model.addAttribute("keyboard_buttons", buttonService.getKeyboardButtonsArray());
        model.addAttribute("connect_users", userService.getConnectUsers());
        model.addAttribute("buttonsNameCodes", ButtonNameCoder.getButtonsCodes());
        model.addAttribute("controlButtonDto", new ControlButtonDto());

        return "usage/console_settings";
    }

}
