package p5servlet.usageApplicatonServlet;

import by.arsy.p1util.JspGuide;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("control_buttons_size") == null) {
            session.setAttribute("control_buttons_size", 360);
        }
        req.getRequestDispatcher(JspGuide.to("usage","menu")).forward(req, resp);
    }
}
