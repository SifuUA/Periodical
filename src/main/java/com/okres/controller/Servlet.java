package com.okres.controller;

import com.okres.controller.command.*;
import com.okres.controller.command.Exception;
import com.okres.controller.utils.ServletUtility;
import com.okres.model.service.EditionService;
import com.okres.model.service.PaymentService;
import com.okres.model.service.ReaderService;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */
@WebServlet(urlPatterns = "/servlet/*")
public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new ConcurrentHashMap<>();
    private static final Logger logger = Logger.getLogger(Servlet.class);
    public static String langFlag;

    @Override
    public void init(ServletConfig config) {
        EditionService editionService = new EditionService();
        ServletUtility servletUtility = new ServletUtility();
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
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


    /**
     * One method for process doGet and doPost requests and response
     *
     * @see #doGet(HttpServletRequest, HttpServletResponse)
     * @see #doPost(HttpServletRequest, HttpServletResponse)
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        langFlag = (String) request.getSession().getAttribute("lang");
        logger.info("Choose language: " + langFlag);
        getCommand(request, response);
    }


    /**
     * Control and process all requests from browser
     * and choose correct command that is created in
     *
     * @see #init(ServletConfig)
     */
    private void getCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        if (path.contains("admin/"))
            path = path.replaceAll(".*/servlet/admin/", "");
        else
            path = path.replaceAll(".*/servlet/", "");

        Command command = commands.getOrDefault(path, (req, res) -> "redirect: home");
        String page = command.execute(request, response);
        if (page.contains("redirect:")) {
            String destination = page.replaceAll("redirect: ", "");
            logger.info("Redirect on chosen command: " + destination);
            response.sendRedirect(request.getContextPath() + "/servlet/" + destination);
        } else {
            request.getRequestDispatcher(page).forward(request, response);
            logger.info("Forward on page: " + page);
        }
    }
}

