package com.okres.controller;

import com.okres.controller.command.Command;
import com.okres.controller.command.Login;
import com.okres.controller.command.Logout;
import com.okres.model.entity.Reader;
import com.okres.model.service.ReaderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@WebServlet("/home")
public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();
    private ReaderService readerService = new ReaderService();

    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute("loggedUsers", new HashSet<String>());
        commands.put("login", new Login(new ReaderService()));
        commands.put("logout", new Logout());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/main.jsp");
        dispatcher.forward(req, resp);
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        String loginButton = request.getParameter("loginButton");
        if (loginButton != null)
            path = "login";

        Command command = commands.getOrDefault(path, (req, res)->"/main.jsp");
        String page = command.execute(request, response);

        System.out.println(path);
        System.out.println("AAA" + request.getParameter("buttton"));
    }
}
