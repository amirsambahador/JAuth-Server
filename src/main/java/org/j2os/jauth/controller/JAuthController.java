package org.j2os.jauth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class JAuthController implements Filter {

    static {
        System.out.println();
        System.out.println();
        System.out.println("     ██╗ █████╗ ██╗   ██╗████████╗██╗  ██╗\n" +
                           "     ██║██╔══██╗██║   ██║╚══██╔══╝██║  ██║\n" +
                           "     ██║███████║██║   ██║   ██║   ███████║\n" +
                           "██   ██║██╔══██║██║   ██║   ██║   ██╔══██║\n" +
                           "╚█████╔╝██║  ██║╚██████╔╝   ██║   ██║  ██║\n" +
                           " ╚════╝ ╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚═╝  ╚═╝");
        System.out.println();
        System.out.println();
    }

    @Value("${jauth.token}")
    private String jAuthToken;

    public List<String> getProtectedURL() {
        return Arrays.asList(
                "/api/user/save",
                "/api/user/update",
                "/api/user/remove",
                "/api/user/addRole",
                "/api/user/findAll",
                "/api/user/findByToken",
                "/api/user/findByUsername",
                "/api/user/findById",
                "/api/role/save",
                "/api/role/remove",
                "/api/role/findAll",
                "/api/role/findByRoleName",
                "/api/role/findById"
        );
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getParameter("jauth-token") != null && request.getParameter("jauth-token").equals(this.jAuthToken))
            filterChain.doFilter(servletRequest, servletResponse);
        else if (getProtectedURL().contains(request.getRequestURI()))
            response.sendError(401);
        else
            filterChain.doFilter(servletRequest, servletResponse);
    }
}
