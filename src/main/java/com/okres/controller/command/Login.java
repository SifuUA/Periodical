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
import java.util.Optional;


public class Login implements Command {
    private ReaderService readerService;
    private HttpSession httpSession;

    public Login(ReaderService readerService) {
        this.readerService = readerService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        httpSession = request.getSession();

        if (!isHasAcces())
            return "redirect: home";

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Optional<Reader> reader = readerService.getReaderByEmailAndPassword(email, password);
        if (!reader.isPresent())
            return "redirect: registration";
        httpSession.setAttribute("role", reader.get().getRole());
        httpSession.setAttribute("name", reader.get().getFirstName());
        httpSession.setAttribute("reader", reader.get());

        return "redirect: home";
    }

    public boolean isHasAcces() {
        return httpSession.getAttribute("role") == null ||
                httpSession.getAttribute("role").equals(Role.GUEST);
    }




   /*     response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);*/
       /* if (request.getSession().getAttribute("reader") == null &&
                request.getParameter("email") == null && isNull(request.getParameter("password"))
                && isNull(request.getParameter("password"))) {
            response.sendRedirect("/WEB-INF/views/main.jsp");
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Role currentRole = (Role) request.getSession().getAttribute("role");
        System.out.println("Current role + " + currentRole);
        //Reader readerFromSession = (Reader) request.getSession().getAttribute("role");

        if (email == null || password == null) {
            return "/WEB-INF/views/main.jsp";
        }
        Optional<Reader> reader = readerService.getReaderByEmailAndPassword(email, password);
        if (reader.isPresent() && request.getSession().isNew() *//*&& (isNull(currentRole) || !currentRole.equals(Role.GUEST))*//*) {
            if (reader.get().getId() == 1) {
                reader.get().setRole(Role.ADMIN);
                request.getSession().setAttribute("reader", reader.get());
                request.getSession().setAttribute("role", Role.ADMIN);

                return "/WEB-INF/views/admin.jsp";
            } else {
                reader.get().setRole(Role.READER);
                request.getSession().setAttribute("reader", reader.get());
                request.getSession().setAttribute("role", Role.READER);
                return "/WEB-INF/views/reader.jsp";

            }
        }
        if (isNull(currentRole))
            return "/WEB-INF/views/registration.jsp";
        else {
            request.getSession().setAttribute("role", null);
            return "redirect: home";
        }

    }*/
}
