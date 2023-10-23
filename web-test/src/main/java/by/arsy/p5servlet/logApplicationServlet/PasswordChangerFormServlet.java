package by.arsy.p5servlet.logApplicationServlet;

import by.arsy.p1util.JspGuide;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/change_pass_form")
public class PasswordChangerFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspGuide.to("log", "change_password")).forward(req, resp);
    }
}
