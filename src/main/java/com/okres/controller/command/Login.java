package com.okres.controller.command;

import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.ReaderService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Login implements Command {

   /* private ReaderService readerService;

    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession httpSession;

    public Login(ReaderService readerService, ServletContext servletContext, HttpServletRequest servletRequest,
                 HttpServletResponse servletResponse) {
        this.readerService = readerService;
        this.context = servletContext;
        this.request = servletRequest;
        this.response = servletResponse;
        this.httpSession = servletRequest.getSession();
    }

    public Login(ReaderService readerService) {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAccessAllowed()) {
            response.sendRedirect(context.getContextPath() + "/servlet/" + "home");
            return null;
        }
        Optional<Reader> optional = null;
        System.out.println("check1");
        try {
            optional = readerService.getReaderByEmailAndPassword(request.getParameter("username"), request.getParameter("password"));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        System.out.println("check2");
        if (!optional.isPresent()) {
            response.sendRedirect(context.getContextPath() + "/servlet/" + "login");
            return null;
        }
        List<Reader> loggedUsers = (List<Reader>) context.getAttribute("logged-users");
        loggedUsers.add(optional.get());
        System.out.println("check3");
        for (int i = 0; i < loggedUsers.size(); i++) {
            System.out.println(loggedUsers.get(i));
        }
        System.out.println("check4");
        HttpSession session = request.getSession();
        session.setAttribute("role", optional.get().getRole().name());
        session.setAttribute("username", request.getParameter("username"));
        response.sendRedirect(context.getContextPath() + "/servlet/" + "home");

        return null;
    }

    public boolean isAccessAllowed() {
        return httpSession.getAttribute("role") == null || httpSession.getAttribute("role").equals("UNKNOWN");
    }*/


        /*String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null)
            return "/WEB-INF/views/main.jsp";
        Optional<Reader> reader = readerService.getReaderByEmailAndPassword(email, password);
        if (reader.isPresent()) {
            if (reader.get().getId() == 1) {
                reader.get().setRole(Role.ADMIN);
                request.getSession().setAttribute("reader", "USER");
                return "/WEB-INF/views/admin.jsp";
            }
            else {
                reader.get().setRole(Role.READER);
                request.getSession().setAttribute("reader", reader.get());
                return "/WEB-INF/views/reader.jsp";

            }

        } else
            request.getSession().setAttribute("reader", readerService.createGuestReader());
        request.getSession().setAttribute("reader", "USER");
        return "/WEB-INF/views/main.jsp";*/

    private ReaderService readerService;

    public Login(ReaderService readerService) {
        this.readerService = readerService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null)
            return "/WEB-INF/views/main.jsp";
        Optional<Reader> reader = readerService.getReaderByEmailAndPassword(email, password);
        if (reader.isPresent()) {
            if (reader.get().getId() == 1) {
                reader.get().setRole(Role.ADMIN);
                request.getSession().setAttribute("reader", reader.get());
                return "/WEB-INF/views/admin.jsp";
            }
            else {
                reader.get().setRole(Role.READER);
                request.getSession().setAttribute("reader", reader.get());
                return "/WEB-INF/views/reader.jsp";

            }

        } else {
            request.getSession().setAttribute("reader", readerService.createGuestReader());
        }
        return "/WEB-INF/views/main.jsp";
    }
    }
