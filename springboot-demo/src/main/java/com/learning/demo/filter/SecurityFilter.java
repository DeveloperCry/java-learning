package com.learning.demo.filter;

import com.learning.demo.constants.Constant;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter
public class SecurityFilter implements Filter {

    private static final String[] IGNORE_URI = {"/index", "/css/", "/js/", "/images/", "/login"};
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        System.out.println("uri:" + uri);
        if (canAccess(uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else {
            Object session = request.getSession().getAttribute(Constant.ACCOUNT_SESSION);
            if (session == null) {
                response.sendRedirect("/login");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean canAccess(String uri) {
        for (String str: IGNORE_URI) {
            if (uri.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
