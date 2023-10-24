package by.arsy.p5servlet.usageApplicatonController.menuContent;

import by.arsy.button.ButtonPusher;
import by.arsy.p2entity.KeyboardButtonEntity;
import by.arsy.p2entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/console")
public class ConsoleServlet {

    @Autowired
    private ButtonPusher buttonPusher;
    private static final HashMap<Integer, HashSet<String>> PRESSED_BUTTONS = new HashMap<>();
    private HashMap<Integer, HashMap<String, Optional<KeyboardButtonEntity>>> buttonsValues;
    private int userId;

    @RequestMapping(method = RequestMethod.GET)
    public String preparationConsole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        userId = ((User) session.getAttribute("user")).getId();

        Object buttonsValuesAttribute = session.getAttribute("buttons_values");
        buttonsValues = (HashMap<Integer, HashMap<String, Optional<KeyboardButtonEntity>>>) buttonsValuesAttribute;
        req.getRequestDispatcher("/settings_button").include(req,resp);
        return "usage/console";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void useConsole(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Optional<String> optionalButtonName = Optional.ofNullable(req.getParameter("button_name"));

        if (optionalButtonName.isPresent()) {
            String buttonName = optionalButtonName.get();

            if (!PRESSED_BUTTONS.containsKey(userId)) {
                PRESSED_BUTTONS.put(userId, new HashSet<>());
            }

            if (buttonsValues.get(userId).containsKey(buttonName.toUpperCase(Locale.ROOT))) {
                if (req.getParameter("check_box").equals("true")) {
                    if (PRESSED_BUTTONS.get(userId).add(buttonName)) {
                        buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT)).ifPresent(buttonPusher::press);
                        resp.setCharacterEncoding("UTF-8");
                        resp.setContentType("application/json");
                        resp.getWriter().write("{\"button_color\": \"blue\"}");
                    } else {
                        buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT)).ifPresent(buttonPusher::release);
                        PRESSED_BUTTONS.get(userId).remove(buttonName);
                    }
                } else {
                    PRESSED_BUTTONS.get(userId).remove(buttonName);
                    buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT)).ifPresent(buttonPusher::push);
                }
            }
        }
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public void releaseAllButtons() {
        PRESSED_BUTTONS.get(userId)
                .forEach(buttonName -> {
                    Optional<KeyboardButtonEntity> buttonEntity =
                            buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT));
                    buttonEntity.ifPresent(buttonPusher::release);
                });
        PRESSED_BUTTONS.clear();

    }


}
