package com.okres.controller.command;



import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.Edition;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.EditionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AdminPage implements Command {
    private ServletUtility servletUtility = new ServletUtility();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        if (servletUtility.getCurrentImages(request))
            return "redirect: edition";
        if (!request.getSession().getAttribute("role").equals(Role.ADMIN))
            return "/WEB-INF/views/main.jsp";
        return "/WEB-INF/views/admin.jsp";
    }


}
