package com.okres.controller.command;

import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class AdminPage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletUtility servletUtility = new ServletUtility();

        if (servletUtility.getCurrentImages(request))
            return "redirect: edition";
        if (!request.getSession().getAttribute("role").equals(Role.ADMIN))
            return "/WEB-INF/views/main.jsp";
        return "/WEB-INF/views/admin.jsp";
    }


}
