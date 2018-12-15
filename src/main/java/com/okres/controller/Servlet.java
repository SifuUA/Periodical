package com.okres.controller;

import com.okres.controller.command.Command;
import com.okres.controller.command.Login;
import com.okres.controller.command.Logout;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@WebServlet("/app")
public class Servlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        Map<String, Command> commands = new HashMap<>();
        config.getServletContext().setAttribute("loggedUsers", new HashSet<String>());
        commands.put("login", new Login());
        commands.put("logout", new Logout());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {

    }
}
