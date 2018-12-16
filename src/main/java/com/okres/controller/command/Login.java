package com.okres.controller.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //if (email == null)

        return null;
    }

    /*@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");


        if (name == null || name.equals("") || pass == null || pass.equals("")) {
            return "/login.jsp";
        }
        if (ServletUtility.checkUserIsLogged(request, name)) {
            return "/WEB-INF/error.jsp";
        }

        User.ROLE role = getUserRole(name);
        ServletUtility.logIn(request, name);
        ServletUtility.setUserRole(request, role, name);

        return getRedirectPath(role);
    }

    private User.ROLE getUserRole(String name) {
        try {
            Properties properties = new Properties();
            ClassLoader cl = this.getClass().getClassLoader();
            InputStream is = cl.getResourceAsStream("users.properties");
            properties.load(is);

            String roleStr = properties.getProperty(name, User.ROLE.UNKNOWN.toString());
            return User.ROLE.valueOf(roleStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return User.ROLE.UNKNOWN;
    }

    private String getRedirectPath(User.ROLE role) {
        if (role == User.ROLE.ADMIN) {
            return "redirect: /admin";
        } else if (role == User.ROLE.USER) {
            return "redirect: /user";
        } else return "/login.jsp";*/
    }
        /*String login = request.getParameter("login");
        String password = request.getParameter("password");


        if (ServletUtility.checkIfUserIsLogged(request, login))
            return "/jsp/error.jsp";

*/

        /*RequestDispatcher dispatcher //
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/main.jsp");

        dispatcher.forward(request, response);*/

/*
}
}
*/
