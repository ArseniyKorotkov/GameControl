package by.arsy.controller.usageApplicatonController;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/menu")
public class MenuController extends HttpServlet {

    private static final int START_BUTTONS_SIZE = 360;

    @RequestMapping(method = RequestMethod.GET)
    public String menuPreparation(HttpSession session) {
        if (session.getAttribute("control_buttons_size") == null) {
            session.setAttribute("control_buttons_size", START_BUTTONS_SIZE);
        }
        return "usage/menu";
    }
}
