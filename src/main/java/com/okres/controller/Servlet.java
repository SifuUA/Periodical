package com.okres.controller;

import com.okres.controller.command.*;
import com.okres.controller.command.Exception;
import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.Edition;
import com.okres.model.service.EditionService;
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
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/servlet/*")
public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();
    private ReaderService readerService = new ReaderService();
    private EditionService editionService = new EditionService();
    private List<Edition> editionList = editionService.getAllEditions();


    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute("loggedUsers", new HashSet<String>());
        /*servletUtility.setEditionImage(request, response);
        servletUtility.setCategory(request, response);*/
        commands.put("login", new Login(new ReaderService()));
        commands.put("home", new MainPage());
        commands.put("logout", new Logout());
        commands.put("admin", new AdminPage());
        commands.put("reader", new ReaderPage());
        commands.put("registration", new RegistrationPage());
        commands.put("error", new Exception());
        commands.put("upload", new Upload());
        commands.put("uploadForm", new UploadForm());
        commands.put("viewReaders", new ViewReaders());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("editionList", editionList);
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getCommand(request, response);
    }

    private void getCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.contains("admin/"))
            path = path.replaceAll(".*/servlet/admin/", "");
        else
            path = path.replaceAll(".*/servlet/", "");

        //Command command = commands.getOrDefault(path, (req, res) -> "/WEB-INF/views/main.jsp");
        Command command = commands.getOrDefault(path, (req, res) -> "redirect: home");
        String page = command.execute(request, response);

        if (page.contains("redirect:")) {
            String destination = page.replaceAll("redirect: ", "");
            System.out.println(destination);
            response.sendRedirect(request.getContextPath() + "/servlet/" + destination);
            return;
        } else
            request.getRequestDispatcher(page).forward(request, response);
    }


}

