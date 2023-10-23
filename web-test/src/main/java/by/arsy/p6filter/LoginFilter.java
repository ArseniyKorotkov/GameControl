package by.arsy.p6filter;

import by.arsy.p2entity.User;
import by.arsy.p4service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/button", "/console", "/menu", "/delete_account_form",
"/delete_account", "/logout", "/master_menu", "/change_pass_form", "/change_pass",
"/user_save", "/console_settings", "/save_button_settings"})
public class LoginFilter implements Filter {

    private final UserService service = UserService.getInstance();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession();
        if (session.getAttribute("user") != null && service.haveName(((User)session.getAttribute("user")).getName())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            service.logoutUser((User)session.getAttribute("user"));
            session.invalidate();
            ((HttpServletResponse) servletResponse).sendRedirect("control");
        }

    }
}
