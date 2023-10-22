package p5servlet.usageApplicatonServlet.menuContent;

import by.arsy.p1util.JspGuide;
import by.arsy.p4service.ButtonService;
import by.arsy.p4service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/console_settings")
public class ConsoleSettingsServlet extends HttpServlet {

    private final ButtonService buttonService = ButtonService.getInstance();
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("keyboard_buttons", buttonService.getKeyboardButtonsArray());
        req.setAttribute("connect_users", userService.getConnectUsers());

        req.getRequestDispatcher(JspGuide.to("usage","console_settings")).forward(req, resp);
    }
}
