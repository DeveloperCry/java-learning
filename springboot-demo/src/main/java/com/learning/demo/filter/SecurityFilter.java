package com.learning.demo.filter;

import com.learning.demo.constants.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ExportException;

@Slf4j
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

        try {
//            String uri = request.getRequestURI();
//            System.out.println("uri:" + uri);
//            if (canAccess(uri)) {
//                filterChain.doFilter(servletRequest, servletResponse);
//                return;
//            } else {
//                Object session = request.getSession().getAttribute(Constant.ACCOUNT_SESSION);
//                if (session == null) {
//                    response.sendRedirect("/login");
//                    return;
//                }
//            }
            log.info("执行filter。。。。。。。。");
            filterChain.doFilter(servletRequest, servletResponse);
            log.info("在doFilter之后完成调用。。。。");
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            log.info("Filter 完成。。。。。。。。。。。");
        }
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
