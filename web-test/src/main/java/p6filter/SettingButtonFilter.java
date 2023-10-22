package p6filter;

import by.arsy.p2entity.ControlButton;
import by.arsy.p2entity.KeyboardButtonEntity;
import by.arsy.p2entity.User;
import by.arsy.p4service.ButtonService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;

@WebFilter({"/console", "/console_settings"})
public class SettingButtonFilter implements Filter {

    private static final HashMap<Integer, HashMap<String, Optional<KeyboardButtonEntity>>> BUTTONS_VALUES = new HashMap<>();
    private final ButtonService service = ButtonService.getInstance();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("user");
        takeButtonsValues(session, user.getId());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void takeButtonsValues(HttpSession session, int userId) {
        Optional<Object> isOldValuesButtons = Optional.ofNullable(session.getAttribute("is_old_values_buttons"));
        if (isOldValuesButtons.isEmpty() || !(boolean) isOldValuesButtons.get()) {
            if (!BUTTONS_VALUES.containsKey(userId)) {
                BUTTONS_VALUES.put(userId, new HashMap<>());
            }
            Arrays.stream(ControlButton.values())
                    .map(ControlButton::name)
                    .forEach(consoleButton -> {
                        Optional<KeyboardButtonEntity> buttonValue = service.getButtonValue(userId, consoleButton);
                        if(buttonValue.isPresent()) {
                            BUTTONS_VALUES.get(userId).put(consoleButton, buttonValue);
                            session.setAttribute(consoleButton.toLowerCase(Locale.ROOT) + "_value",
                                    buttonValue.get().name().split("_")[1]);
                        }
                    });
            session.setAttribute("buttons_values",BUTTONS_VALUES);
            session.setAttribute("is_old_values_buttons", true);
        }
    }
}
