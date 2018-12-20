package com.okres.controller.filter;

import com.okres.controller.config.SecurityConfig;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter
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
        ServletContext context = servletRequest.getServletContext();

        System.out.println(session);
        System.out.println(context);
        System.out.println(SecurityConfig.getAllAppRoles().toString());
        System.out.println(SecurityConfig.getAllAppRoles().toString());
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
        filterChain.doFilter(req,res);
    }

    @Override
    public void destroy() {

    }
}
