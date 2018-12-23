package com.okres.controller.command;

import com.okres.model.entity.enums.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!request.getSession().getAttribute("role").equals(Role.ADMIN))
            return "/WEB-INF/views/main.jsp";
        return "/WEB-INF/views/admin.jsp";
    }
}
