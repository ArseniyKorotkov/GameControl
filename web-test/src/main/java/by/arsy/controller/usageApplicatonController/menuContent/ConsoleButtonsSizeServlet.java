package by.arsy.controller.usageApplicatonController.menuContent;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/console_buttons_size")
public class ConsoleButtonsSizeServlet {

    private static final int SWITCH_SIZE = 20;
    private static final int MIN_SIZE = 100;
    private static final int MAX_SIZE = 600;
    private static final String DECREASE_SIZE_CODE = "small";
    private static final String INCREASE_SIZE_CODE = "big";

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> changeSize(@RequestParam("changeSizeTo") String changeSizeCode,
                                                          HttpSession session) {

        int nowSize = (int) session.getAttribute("control_buttons_size");

        if (DECREASE_SIZE_CODE.equals(changeSizeCode) && nowSize > MIN_SIZE) {
            nowSize -= SWITCH_SIZE;
        } else if (INCREASE_SIZE_CODE.equals(changeSizeCode) && nowSize < MAX_SIZE) {
            nowSize += SWITCH_SIZE;
        }

        session.setAttribute("control_buttons_size", nowSize);

        return ResponseEntity.ok(Map.of("control_buttons_size", nowSize));
    }

}
