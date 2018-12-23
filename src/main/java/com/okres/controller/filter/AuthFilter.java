package com.okres.controller.filter;

import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.ReaderService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static java.util.Objects.nonNull;

//@WebFilter(urlPatterns = "/")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;

        request.getSession().setAttribute("role", Role.GUEST);

        /*ReaderService readerService = new ReaderService();
        Optional<Reader> optional = null;
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final HttpSession session = request.getSession();

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");


        if (nonNull(session) && nonNull(session.getAttribute(email))
                && nonNull(session.getAttribute(password))) {
            final Role role = (Role) session.getAttribute("role");

        } else if (readerService.getReaderByEmailAndPassword(email, password).isPresent()) {
            optional = readerService.getReaderByEmailAndPassword(email, password);
            final Role role = optional.get().getRole();
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);
            request.getSession().setAttribute("role", role);
        } else
            request.getSession().setAttribute("role", Role.GUEST);*/
    }

    @Override
    public void destroy() {

    }
}
