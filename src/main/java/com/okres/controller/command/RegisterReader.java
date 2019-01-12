package com.okres.controller.command;

import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.ReaderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.nonNull;

public class RegisterReader implements Command {
    private ReaderService readerService = new ReaderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = new String(request.getParameter("fname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String lastName = new String(request.getParameter("lname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = new String(request.getParameter("password").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        if (nonNull(firstName) && nonNull(lastName) && nonNull(phoneNumber) && nonNull(email) && nonNull(password)) {
            Reader reader = new Reader(firstName, lastName, phoneNumber, email, password, Role.READER);
            if (!readerService.readerIsRegistred(reader))
                readerService.createReader(reader);
        }
        return "redirect: home";
    }
}
