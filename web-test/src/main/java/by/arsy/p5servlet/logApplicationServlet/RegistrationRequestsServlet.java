package by.arsy.p5servlet.logApplicationServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/registration_requests")
public class RegistrationRequestsServlet extends HttpServlet {

    @RequestMapping(method = RequestMethod.GET)
    public String registrationMasterVerdict(HttpServletRequest req) {
        ArrayList<String> installedUsersList = new ArrayList<>();
        Optional<Object> installedUsers = Optional.ofNullable(req.getServletContext().getAttribute("logg_users"));
        if (installedUsers.isPresent() && installedUsers.get() instanceof HashMap<?, ?>) {
            Map<String, String> installedUsersMap = (HashMap<String, String>) installedUsers.get();
            installedUsersList.addAll(installedUsersMap.keySet());
        }
        req.setAttribute("installed_users", installedUsersList);
        return "log/user_save";
    }
}
