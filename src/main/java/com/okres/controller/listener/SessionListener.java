package com.okres.controller.listener;

import com.okres.controller.command.ServletUtility;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Set;

@WebListener
public class SessionListener implements HttpSessionListener {

    private static int activeSessions;

    public static int getActiveSessions() {
        return activeSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session is created");
        activeSessions++;
        System.out.println("Count od sessions are " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        Set<String> loggedUsers = ServletUtility.getLoggedUsers(httpSessionEvent);

        String login = ServletUtility.getUserLogin(session);
        loggedUsers.remove(login);

        ServletUtility.setLoggedUsers(session, loggedUsers);
        System.out.println("Session is destroyed");
    }
}
