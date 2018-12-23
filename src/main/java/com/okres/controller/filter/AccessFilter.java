package com.okres.controller.filter;

import com.okres.controller.config.SecurityConfig;
import com.okres.model.entity.enums.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(value = {"/servlet/admin", "/servlet/reader"})
public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {



        /*HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();*/

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        String requestUri = req.getRequestURI();
        if (requestUri.contains("admin")) {
            if (nonNull(session.getAttribute("role")) &&
                    req.getSession().getAttribute("role").equals(Role.ADMIN))
                filterChain.doFilter(req, res);
            else {
                servletResponse.getWriter().append("AccessDenied");
                return;
            }
        } else if (requestUri.contains("reader")) {
            if (nonNull(session.getAttribute("role")) &&
                    req.getSession().getAttribute("role").equals(Role.READER))
                filterChain.doFilter(req, res);
            else {
                servletResponse.getWriter().append("AccessDenied");
                return;
            }
        }
        filterChain.doFilter(req, res);

        //if (nonNull(session.getAttribute("role")) && !session.getAttribute("role").equals(Role.ADMIN)) {

          /*  RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/errorPage");

            dispatcher.forward(req, res);*/
        //}

        /*ServletContext context = servletRequest.getServletContext();

        System.out.println(session);
        System.out.println(context);
        System.out.println(SecurityConfig.getAllAppRoles().toString());
        System.out.println(SecurityConfig.getAllAppRoles().toString());*/
        /*if(path.contains("add-student")) {//TODO: rewrite add user roles
            if ((teacher = (Teacher) ((HttpServletRequest) servletRequest).getSession().getAttribute("teacher")) != null) {
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                servletResponse.getWriter().append("AccessDenied");
                return;
            }
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }*/
        //filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
