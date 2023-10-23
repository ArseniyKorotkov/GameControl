package by.arsy.p5servlet.usageApplicatonServlet.menuContent;

import by.arsy.p2entity.ControlButton;
import by.arsy.p2entity.KeyboardButtonEntity;
import by.arsy.p2entity.User;
import by.arsy.p4service.ButtonService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

@WebServlet("/save_button_settings")
public class SaveButtonSettingsServlet extends HttpServlet {

    private static User user;
    private final ButtonService service = ButtonService.getInstance();
    private static final HashSet<KeyboardButtonEntity> CONTROL_RATIO = new HashSet<>();
    private static final ArrayList<String[]> responseArray = new ArrayList<>();
    private static final String BUTTON_PREFIX = "VK_";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        clearResults(req);

        Arrays.stream(ControlButton.values())
                .forEach(button -> putIntoSet(button, req.getParameter(button.name().toLowerCase(Locale.ROOT))));

        checkBeforeSend();

        req.getSession().setAttribute("is_old_values_buttons", false);
        req.getSession().setAttribute("answers_message", responseArray);
        resp.sendRedirect("console_settings");
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
            responseArray.addAll(service.saveConsoleButtonsValues(CONTROL_RATIO));
        } else {
            responseArray.add(new String[]{"Not save.", " Have double of buttons"});
        }
    }
}
