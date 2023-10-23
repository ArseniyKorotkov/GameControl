package by.arsy.p5servlet;

import by.arsy.p1util.JspGuide;
import by.arsy.p4service.AppService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/control")
public class StartServlet extends HttpServlet {

    private final AppService appService = AppService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("answer_for_request_log", "");

        appService.activateTables();
        req.getRequestDispatcher(JspGuide.to("start")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspGuide.to("start")).forward(req,resp);
    }
}
