package by.arsy.p5servlet.usageApplicatonServlet.menuContent;

import by.arsy.button.ButtonPusher;
import by.arsy.p1util.JspGuide;
import by.arsy.p2entity.KeyboardButtonEntity;
import by.arsy.p2entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/console")
public class ConsoleServlet extends HttpServlet {
    private final ButtonPusher buttonPusher = ButtonPusher.getInstance();
    private static final HashMap<Integer, HashSet<String>> PRESSED_BUTTONS = new HashMap<>();
    private HashMap<Integer, HashMap<String, Optional<KeyboardButtonEntity>>> buttonsValues;
    private int userId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        userId = ((User) session.getAttribute("user")).getId();

        Object buttonsValuesAttribute = session.getAttribute("buttons_values");
        buttonsValues = (HashMap<Integer, HashMap<String, Optional<KeyboardButtonEntity>>>) buttonsValuesAttribute;

        req.getRequestDispatcher(JspGuide.to("usage", "console")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
                        PrintWriter printWriter = resp.getWriter();
                        printWriter.write("{\"button_color\": \"blue\"}");
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

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PRESSED_BUTTONS.get(userId)
                .forEach(buttonName -> {
                    Optional<KeyboardButtonEntity> buttonEntity =
                            buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT));
                    buttonEntity.ifPresent(buttonPusher::release);
                });

    }
}
