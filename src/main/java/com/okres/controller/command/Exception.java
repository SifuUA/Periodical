package com.okres.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.System.out;

public class Exception implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        return "/WEB-INF/views/errorPage.jsp";
    }
}
