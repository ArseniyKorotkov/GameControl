package by.arsy.p5servlet.logApplicationServlet;

import by.arsy.p2entity.User;
import by.arsy.p4service.ButtonService;
import by.arsy.p4service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/delete_account")
public class DeleteAccountServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    private final ButtonService buttonService = ButtonService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        ArrayList<String> findNamesCanDeleteUsers = userService.findNamesCanDeleteUsers(user.getName());
        for(String name : findNamesCanDeleteUsers) {
            if(req.getParameter(name + "_delete_account") != null) {
                buttonService.deleteConsoleValuesFor(userService.getIdByName(name));
                userService.deleteUserByName(name);
            }
        }

        resp.sendRedirect("delete_account_form");
    }
}
