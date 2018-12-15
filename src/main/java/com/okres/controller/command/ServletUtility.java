package com.okres.controller.command;

import com.okres.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.util.HashSet;
import java.util.Set;

public class ServletUtility {

    /**
     * Method for set user login(email) and role to the session
      */
    public static void setUserRole(HttpServletRequest request, Role role, String login) {

        HttpSession session = request.getSession();
        session.setAttribute("login", login);
        session.setAttribute("role", role);
    }

    public static boolean checkIfUserIsLogged(HttpServletRequest request, String login) {

        Set<String> loggedUsers = getLoggedUsers(request);
        return loggedUsers.stream().anyMatch(login::equals);
    }

    public static void login(HttpServletRequest request, String login) {
        Set<String> loggedUsers = getLoggedUsers(request);
        loggedUsers.add(login);
        setLoggedUsers(request, loggedUsers);
    }

    public static void logout(HttpServletRequest request, String login) {
        Set<String> loggedUsers = getLoggedUsers(request);
        loggedUsers.remove(login);
        setLoggedUsers(request, loggedUsers);
    }

    private static Set<String> getLoggedUsers(HttpServletRequest request) {
       return (HashSet<String>)request.getServletContext().getAttribute("loggedUsers");
    }

    public static Set<String> getLoggedUsers(HttpSessionEvent event) {
        return (HashSet<String>) event.getSession().getServletContext().getAttribute("loggedUsers");
    }


    private static void setLoggedUsers(HttpServletRequest request, Set<String> loggedUsers) {
        request.getServletContext().setAttribute("loggedUsers", loggedUsers);
    }

    public static void setLoggedUsers(HttpSessionEvent event, Set<String> loggedUsers) {
        event.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);
    }

}
