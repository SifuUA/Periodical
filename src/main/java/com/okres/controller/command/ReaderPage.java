package com.okres.controller.command;

import com.okres.controller.utils.ServletUtility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class ReaderPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletUtility servletUtility = new ServletUtility();

        if (servletUtility.getCurrentImages(request))
            return "redirect: edition";
        return "/WEB-INF/views/reader.jsp";
    }
}
