package by.arsy.controller;

import by.arsy.p4service.AppService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/control")
public class StartController {

    @Autowired
    private AppService appService;

    @RequestMapping(method = RequestMethod.GET)
    public String firstVisit(HttpSession session) {
        session.setAttribute("answer_for_request_log", "");
        appService.activateTables();
        return "start";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String nextVisit() {
        return "start";
    }
}
