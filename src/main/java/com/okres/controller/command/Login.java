package com.okres.controller.command;

import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.ReaderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Login implements Command {

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

        } else
            request.getSession().setAttribute("reader", readerService.createGuestReader());
        return "/WEB-INF/views/main.jsp";
    }
}
