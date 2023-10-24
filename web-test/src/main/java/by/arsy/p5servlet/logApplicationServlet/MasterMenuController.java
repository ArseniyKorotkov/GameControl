package by.arsy.p5servlet.logApplicationServlet;

import jakarta.servlet.http.HttpServlet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/master_menu")
public class MasterMenuController extends HttpServlet {

    @RequestMapping(method = RequestMethod.POST)
    public String goToMasterMenu() {
        return "log/master_menu";
    }
}
