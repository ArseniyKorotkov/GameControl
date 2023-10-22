package p5servlet.logApplicationServlet;

import by.arsy.p4service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/user_save")
public class UserSaveServlet extends HttpServlet {

    private final UserService service = UserService.getInstance();
    private static final String SAVE_PREFIX = "_save";
    private static final String MASTER_PREFIX = "_master";
    private static final String DELETE_PREFIX = "_delete";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, String> users = (HashMap<String, String>) req.getServletContext().getAttribute("logg_users");
        for(String name : users.keySet()) {
            if(needSaveName(req, name)) {
                service.saveUser(name, users.get(name), needMakeMaster(req, name));
                users.remove(name);
            } else if (needDelete(req, name)) {
                users.remove(name);
            }
        }
        req.getServletContext().setAttribute("logg_users", users);
        resp.sendRedirect("registration_requests");
    }

    private boolean needSaveName(HttpServletRequest req, String name) {
        return req.getParameter(name + SAVE_PREFIX) != null;
    }

    private boolean needMakeMaster(HttpServletRequest req, String name) {
        return req.getParameter(name + MASTER_PREFIX) != null;
    }


    private boolean needDelete(HttpServletRequest req, String name) {
        return req.getParameter(name + DELETE_PREFIX) != null;
    }
}
