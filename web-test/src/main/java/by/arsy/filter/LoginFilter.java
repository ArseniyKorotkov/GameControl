package by.arsy.filter;


import by.arsy.p4service.UserService;
import jakarta.servlet.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

//@WebFilter({"/button", "/console", "/menu", "/delete_account_form",
//"/delete_account", "/logout", "/master_menu", "/change_pass_form", "/change_pass",
//"/user_save", "/console_settings", "/save_button_settings"})
/**change this filter to spring security*/
public class LoginFilter implements Filter {

    @Autowired
    private UserService userService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//        HttpSession session = httpRequest.getSession();
//        if (session.getAttribute("user") != null && userService.haveName(((User) session.getAttribute("user")).getName())) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            userService.logoutUser((User) session.getAttribute("user"));
//            session.invalidate();
//            ((HttpServletResponse) servletResponse).sendRedirect("control");
//        }

    }
}
