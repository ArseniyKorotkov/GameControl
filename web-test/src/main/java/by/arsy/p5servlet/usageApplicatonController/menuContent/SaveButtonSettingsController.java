package by.arsy.p5servlet.usageApplicatonController.menuContent;

import by.arsy.p2entity.ControlButton;
import by.arsy.p2entity.KeyboardButtonEntity;
import by.arsy.p2entity.User;
import by.arsy.p4service.ButtonService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

@Controller
@RequestMapping("/save_button_settings")
public class SaveButtonSettingsController {

    private static User user;
    private static final HashSet<KeyboardButtonEntity> CONTROL_RATIO = new HashSet<>();
    private static final ArrayList<String[]> responseArray = new ArrayList<>();
    private static final String BUTTON_PREFIX = "VK_";

    @Autowired
    private ButtonService buttonService;

    @RequestMapping(method = RequestMethod.POST)
    public String save(HttpServletRequest req) {
        clearResults(req);

        Arrays.stream(ControlButton.values())
                .forEach(button -> putIntoSet(button, req.getParameter(button.name().toLowerCase(Locale.ROOT))));

        checkBeforeSend();

        req.getSession().setAttribute("is_old_values_buttons", false);
        req.getSession().setAttribute("answers_message", responseArray);
        return "redirect:/console_settings";
    }

    private void clearResults(HttpServletRequest req) {
        responseArray.clear();
        CONTROL_RATIO.clear();
        user = (User) req.getSession().getAttribute("user");
    }

    private void putIntoSet(ControlButton controlButton, String buttonName) {
        KeyboardButtonEntity keyboardButton = KeyboardButtonEntity.build(
                BUTTON_PREFIX + buttonName.split(" ")[0],
                user.getId(),
                controlButton
        );
        CONTROL_RATIO.add(keyboardButton);
    }

    private void checkBeforeSend() {
        if (CONTROL_RATIO.size() == ControlButton.values().length) {
            responseArray.addAll(buttonService.saveConsoleButtonsValues(CONTROL_RATIO));
        } else {
            responseArray.add(new String[]{"Not save.", " Have double of buttons"});
        }
    }
}
