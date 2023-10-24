package by.arsy.p5servlet.usageApplicatonController.menuContent;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/console_buttons_size")
public class ConsoleButtonsSizeServlet {

    private final static int SWITCH_SIZE = 20;

    @RequestMapping(method = RequestMethod.POST)
    public void changeSize(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        int size = (int) session.getAttribute("control_buttons_size");
        if ("small".equals(req.getParameter("size")) && size > 100) {
            size -= SWITCH_SIZE;
        } else if ("big".equals(req.getParameter("size")) && size < 600) {
            size += SWITCH_SIZE;
        }
        session.setAttribute("control_buttons_size", size);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("{\"control_buttons_size\":" + size +"}");
    }

}
