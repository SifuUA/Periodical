package com.okres.controller.filter;

import com.okres.model.entity.enums.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(value = {"/servlet/admin/*", "/servlet/reader/*"})
public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String requestUri = req.getRequestURI();
        if (requestUri.contains("admin")) {
            if (nonNull(session.getAttribute("role")) &&
                    req.getSession().getAttribute("role").equals(Role.ADMIN)) {
                filterChain.doFilter(req, res);
                return;
            } else {
                req.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(req, res);
                return;
            }
        } else if (requestUri.contains("reader")) {
            if (nonNull(session.getAttribute("role")) &&
                    req.getSession().getAttribute("role").equals(Role.READER)) {
                filterChain.doFilter(req, res);
                return;
            } else {
                req.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(req, res);
                return;
            }
        }
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
