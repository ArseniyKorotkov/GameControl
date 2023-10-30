package by.arsy.controller.usageApplicatonController.menuContent;

import by.arsy.button.ButtonPusher;
import by.arsy.p2dto.ClickButtonDto;
import by.arsy.p2entity.KeyboardButtonEntity;
import by.arsy.p2entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/console")
public class ConsoleServlet {

    private static final HashMap<Integer, HashSet<String>> PRESSED_BUTTONS = new HashMap<>();

    @Autowired
    private ButtonPusher buttonPusher;
    private HashMap<Integer, HashMap<String, Optional<KeyboardButtonEntity>>> buttonsValues;
    private int userId;

    @RequestMapping(method = RequestMethod.GET)
    public String preparationConsole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        userId = ((User) session.getAttribute("user")).getId();

        req.getRequestDispatcher("/settings_button").include(req, resp);
        Object buttonsValuesAttribute = session.getAttribute("buttons_values");
        buttonsValues = (HashMap<Integer, HashMap<String, Optional<KeyboardButtonEntity>>>) buttonsValuesAttribute;
        return "usage/console";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> useConsole(@RequestBody ClickButtonDto clickButtonDto) {

        Map<String, Object> answer = new HashMap<>();

        String buttonName = clickButtonDto.getButtonName();

        if (!PRESSED_BUTTONS.containsKey(userId)) {
            PRESSED_BUTTONS.put(userId, new HashSet<>());
        }

        if (buttonsValues.get(userId).containsKey(buttonName.toUpperCase(Locale.ROOT))) {
            if (clickButtonDto.getCheckBox()) {
                if (PRESSED_BUTTONS.get(userId).add(buttonName)) {
                    buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT)).ifPresent(buttonPusher::press);
                    answer.put("button_color", "blue");
                } else {
                    buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT)).ifPresent(buttonPusher::release);
                    PRESSED_BUTTONS.get(userId).remove(buttonName);
                }
            } else {
                PRESSED_BUTTONS.get(userId).remove(buttonName);
                buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT)).ifPresent(buttonPusher::push);
            }
        }

        return ResponseEntity.ok(answer);
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
