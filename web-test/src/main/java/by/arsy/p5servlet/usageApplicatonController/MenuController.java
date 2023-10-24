package by.arsy.p5servlet.usageApplicatonController;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/menu")
public class MenuController extends HttpServlet {

    @RequestMapping(method = RequestMethod.GET)
    public String menuPreparation(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session.getAttribute("control_buttons_size") == null) {
            session.setAttribute("control_buttons_size", 360);
        }
        return "usage/menu";
    }
}
