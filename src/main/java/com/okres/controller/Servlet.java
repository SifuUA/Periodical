package com.okres.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/app")
public class Servlet extends HttpServlet {
    private int count;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("p1");
        PrintWriter printWriter = resp.getWriter();

        req.getSession().setAttribute("count", ++count);

        printWriter.println(parameter);
        printWriter.println(count);
        printWriter.println(req.getParameter("count"));
        System.out.println(parameter);
        Enumeration<String> parameterNames = req.getParameterNames();
        System.out.println(parameterNames);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
