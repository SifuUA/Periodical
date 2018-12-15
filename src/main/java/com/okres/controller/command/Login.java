package com.okres.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");


        if (ServletUtility.checkIfUserIsLogged(request, login))
            return "/jsp/error.jsp";



        return null;
    }
}
