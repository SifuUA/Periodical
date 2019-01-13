package com.okres.controller.command;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class Logout implements Command {
    private static Logger logger = Logger.getLogger(Logout.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("role");
        HttpSession session = request.getSession();
        logger.info("User: " + request.getSession().getAttribute("reader") + " is logout. " +
                "Session " + session.getId() + " " + session.getCreationTime() + " is invalidated");
        session.invalidate();
        return "redirect: home";
    }
}
