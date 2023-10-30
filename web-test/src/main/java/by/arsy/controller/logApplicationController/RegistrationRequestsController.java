package by.arsy.controller.logApplicationController;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/registration_requests")
public class RegistrationRequestsController extends HttpServlet {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(method = RequestMethod.GET)
    public String registrationMasterVerdict(Model model) {
        ArrayList<String> installedUsersList = new ArrayList<>();
        Optional<Object> installedUsers = Optional.ofNullable(servletContext.getAttribute("logg_users"));
        if (installedUsers.isPresent() && installedUsers.get() instanceof HashMap<?, ?>) {
            Map<String, String> installedUsersMap = (HashMap<String, String>) installedUsers.get();
            installedUsersList.addAll(installedUsersMap.keySet());
        }
        model.addAttribute("installed_users", installedUsersList);
        return "log/user_save";
    }
}
