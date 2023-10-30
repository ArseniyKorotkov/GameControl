package by.arsy.controller.usageApplicatonController.menuContent;

import by.arsy.p2entity.ControlButton;
import by.arsy.p2entity.KeyboardButtonEntity;
import by.arsy.p2entity.User;
import by.arsy.p4service.ButtonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/settings_button")
public class ButtonSettingsIncludeController {

    private static final HashMap<Integer, HashMap<String, Optional<KeyboardButtonEntity>>> BUTTONS_VALUES = new HashMap<>();
    @Autowired
    private ButtonService buttonService;

    @RequestMapping(method = RequestMethod.GET)
    public String setButtonsValues(HttpSession session) {
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        Optional<Object> isOldValuesButtons = Optional.ofNullable(session.getAttribute("is_old_values_buttons"));
        if (isOldValuesButtons.isEmpty() || !(boolean) isOldValuesButtons.get()) {
            if (!BUTTONS_VALUES.containsKey(userId)) {
                BUTTONS_VALUES.put(userId, new HashMap<>());
            }
            Arrays.stream(ControlButton.values())
                    .map(ControlButton::name)
                    .forEach(consoleButton -> {
                        Optional<KeyboardButtonEntity> buttonValue = buttonService.getButtonValue(userId, consoleButton);
                        if (buttonValue.isPresent()) {
                            BUTTONS_VALUES.get(userId).put(consoleButton, buttonValue);
                            session.setAttribute(consoleButton.toLowerCase(Locale.ROOT) + "_value",
                                    buttonValue.get().name().split("_")[1]);
                        }
                    });
            session.setAttribute("buttons_values", BUTTONS_VALUES);
            session.setAttribute("is_old_values_buttons", true);
        }

        return "usage/menu";
    }
}
