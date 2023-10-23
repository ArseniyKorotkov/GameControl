package by.arsy.p5servlet.logApplicationServlet;

import by.arsy.p1util.JspGuide;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/registration_requests")
public class RegistrationRequestsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> installedUsersList = new ArrayList<>();
        Optional<Object> installedUsers = Optional.ofNullable(req.getServletContext().getAttribute("logg_users"));
        if (installedUsers.isPresent() && installedUsers.get() instanceof HashMap<?, ?>) {
            Map<String, String> installedUsersMap = (HashMap<String, String>) installedUsers.get();
            installedUsersList.addAll(installedUsersMap.keySet());
        }
        req.setAttribute("installed_users", installedUsersList);
        req.getRequestDispatcher(JspGuide.to("log", "user_save")).forward(req, resp);
    }
}
