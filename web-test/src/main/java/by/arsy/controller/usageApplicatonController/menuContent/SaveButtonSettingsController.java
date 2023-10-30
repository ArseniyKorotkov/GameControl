package by.arsy.controller.usageApplicatonController.menuContent;

import by.arsy.p2dto.ControlButtonDto;
import by.arsy.p2entity.ControlButton;
import by.arsy.p2entity.KeyboardButtonEntity;
import by.arsy.p2entity.User;
import by.arsy.p4service.ButtonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

@Controller
@RequestMapping("/save_button_settings")
public class SaveButtonSettingsController {

    private static final HashSet<KeyboardButtonEntity> CONTROL_RATIO = new HashSet<>();
    private static final ArrayList<String[]> responseArray = new ArrayList<>();
    private static final String BUTTON_PREFIX = "VK_";
    private static User user;

    @Autowired
    private ButtonService buttonService;

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute ControlButtonDto controlButtonDto,
                       HttpSession session) {

        clearResults(session);

        controlButtonDto.getButtonDtos().forEach(buttonDto -> {
            KeyboardButtonEntity keyboardButton = KeyboardButtonEntity.build(
                    BUTTON_PREFIX + buttonDto.getValue().split(" ")[0],
                    user.getId(),
                    ControlButton.valueOf(buttonDto.getName().toUpperCase(Locale.ROOT))
            );
            CONTROL_RATIO.add(keyboardButton);
        });

        checkBeforeSend();

        session.setAttribute("is_old_values_buttons", false);
        session.setAttribute("answers_message", responseArray);
        return "redirect:/console_settings";
    }

    private void clearResults(HttpSession session) {
        responseArray.clear();
        CONTROL_RATIO.clear();
        user = (User) session.getAttribute("user");
    }

    private void checkBeforeSend() {
        if (CONTROL_RATIO.size() == ControlButton.values().length) {
            responseArray.addAll(buttonService.saveConsoleButtonsValues(CONTROL_RATIO));
        } else {
            responseArray.add(new String[]{"Not save.", " Have double of buttons"});
        }
    }
}
