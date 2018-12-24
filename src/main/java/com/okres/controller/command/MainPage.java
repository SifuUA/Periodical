package com.okres.controller.command;

import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.enums.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.isNull;

public class MainPage implements Command {
    private ServletUtility servletUtility = new ServletUtility();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        servletUtility.setEditionImage(request, response);
        servletUtility.setCategory(request, response);
        HttpSession httpSession = request.getSession();

        if (isNull(httpSession.getAttribute("role")))
            return "/WEB-INF/views/main.jsp";

        if (httpSession.getAttribute("role").equals(Role.ADMIN))
            return "redirect: admin";
        else if (httpSession.getAttribute("role").equals(Role.READER))
            return "redirect: reader";
        return "/WEB-INF/views/main.jsp";
    }
}
