package com.okres.controller.command;

import com.okres.model.entity.enums.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class Logout implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("role");
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect: home";
    }


    private boolean isHasRights(HttpServletRequest request) {
        Role currentRole = (Role) request.getSession().getAttribute("role");
        return nonNull(currentRole) && (currentRole.equals(Role.ADMIN) || currentRole.equals(Role.READER));
    }
}
