package by.arsy.controller.logApplicationController;

import by.arsy.p4service.UserService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
@RequestMapping("/user_save")
public class UserSaveController {


    private static final String SAVE_PREFIX = "_save";
    private static final String MASTER_PREFIX = "_master";
    private static final String DELETE_PREFIX = "_delete";

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String savaUser(HttpServletRequest req) {
        HashMap<String, String> users = (HashMap<String, String>) servletContext.getAttribute("logg_users");
        for (String name : users.keySet()) {
            if (needSaveName(req, name)) {
                service.saveUser(name, users.get(name), needMakeMaster(req, name));
                users.remove(name);
            } else if (needDelete(req, name)) {
                users.remove(name);
            }
        }
        req.getServletContext().setAttribute("logg_users", users);
        return "redirect:/registration_requests";
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
