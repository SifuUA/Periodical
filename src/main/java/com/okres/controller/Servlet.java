package com.okres.controller;

import com.okres.controller.command.*;
import com.okres.controller.command.Exception;
import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.Edition;
import com.okres.model.service.EditionService;
import com.okres.model.service.PaymentService;
import com.okres.model.service.ReaderService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/servlet/*")
public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();
    private EditionService editionService = new EditionService();
    private List<Edition> editionList = editionService.getAllEditions();
    //!!!!//
    private ServletUtility servletUtility = new ServletUtility();


    @Override
    public void init(ServletConfig config) throws ServletException {
        ReaderService readerService = new ReaderService();
        PaymentService paymentService = new PaymentService();


        config.getServletContext().setAttribute("loggedUsers", new HashSet<String>());
        config.getServletContext().setAttribute("editionList", editionService.getAllEditions());
        config.getServletContext().setAttribute("encodeImages", servletUtility.setEditionImage(config.getServletContext()));
        config.getServletContext().setAttribute("editionCategories", servletUtility.setCategory(config.getServletContext()));

        commands.put("login", new Login(readerService));
        commands.put("home", new MainPage());
        commands.put("logout", new Logout());
        commands.put("admin", new AdminPage());
        commands.put("reader", new ReaderPage());
        commands.put("registration", new RegistrationPage());
        commands.put("error", new Exception());
        commands.put("upload", new Upload());
        commands.put("uploadForm", new UploadForm());
        commands.put("viewReaders", new ViewReaders());
        commands.put("edition", new EditionPage());
        commands.put("subscribe", new Subscribe());
        commands.put("readerSubscription", new ReaderSubscriptions());
        commands.put("registerReader", new RegisterReader());
        commands.put("viewReadersSubscriptionsByAdmin", new AcceptSubscription());
        commands.put("confirm", new ConfitmPayment(readerService, paymentService));
        commands.put("delete", new DeleteEdition());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //!!//
        //req.getSession().setAttribute("editionList", editionList);
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
        System.out.println(path);
        if (path.contains("admin/"))
            path = path.replaceAll(".*/servlet/admin/", "");
        else if (path.matches("/servlet/home/[0-9]+")) {
            String index = path.replaceAll("/servlet/home/", "");
            request.getSession().setAttribute("editionIndex", index);
        } else if (path.matches("/servlet/reader/[0-9]+")) {
            String index = path.replaceAll("/servlet/reader/", "");
            request.getSession().setAttribute("editionIndex", index);
        } else if (path.matches("/servlet/admin/[0-9]+")) {
            String index = path.replaceAll("/servlet/admin/", "");
            request.getSession().setAttribute("editionIndex", index);
        } else
            path = path.replaceAll(".*/servlet/", "");

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

