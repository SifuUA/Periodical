package com.okres.controller;

import com.okres.controller.command.Command;
import com.okres.controller.command.Login;
import com.okres.controller.command.Logout;
import com.okres.controller.command.MainPage;
import com.okres.model.service.ReaderService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@WebServlet(urlPatterns = "/servlet/*")
public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();
    private ReaderService readerService = new ReaderService();

    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute("loggedUsers", new HashSet<String>());
        commands.put("login", new Login(new ReaderService()));
        commands.put("home", new MainPage());
        commands.put("logout", new Logout());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/main.jsp");
        dispatcher.forward(req, resp);*/
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*Command command = getCommand(request, response);
        if (command != null)
            command.execute(request, response);*/
        getCommand(request, response);

    }

    private void getCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        path = path.replaceAll(".*/servlet/", "");
        Command command = commands.getOrDefault(path, (req, res) -> "/WEB-INF/views/main.jsp");
        String page = command.execute(request, response);
        request.getRequestDispatcher(page).forward(request, response);
    }}
        /*Command command = getCommand(request);
        String page = command.execute(request, response);

        if (page.contains("redirect: ")) {
            response.sendRedirect(request.getContextPath() + page.replaceAll("redirect: ", ""));
        } else {
            request.getRequestDispatcher(page).forward(request,response);
        }*/
//   }

    /*private Command getCommand(HttpServletRequest request) {
        String path = request.getRequestURI();
        System.out.println("Before " + path);
        path = path.substring(path.lastIndexOf("/") + 1);
        System.out.println("After " + path);
        return commands.getOrDefault(path, (req, res) -> "/WEB-INF/views/main.jsp");
    }*/

