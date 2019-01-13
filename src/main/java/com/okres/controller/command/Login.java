package com.okres.controller.command;

import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.ReaderService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class Login implements Command {
    private ReaderService readerService;
    private HttpSession httpSession;
    private static Logger logger = Logger.getLogger(Login.class);

    public Login(ReaderService readerService) {
        this.readerService = readerService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        httpSession = request.getSession();

        if (!isHasAccess())
            return "redirect: home";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Optional<Reader> reader = readerService.getReaderByEmailAndPassword(email, password);
        if (!reader.isPresent()) {
            logger.error("Access denied, reader role is a GUEST: " + reader.get());
            return "redirect: registration";
        }
        httpSession.setAttribute("role", reader.get().getRole());
        httpSession.setAttribute("name", reader.get().getFirstName());
        httpSession.setAttribute("reader", reader.get());
        logger.info("Reader is login as: " + reader.get());
        return "redirect: home";
    }

    private boolean isHasAccess() {
        return httpSession.getAttribute("role") == null ||
                httpSession.getAttribute("role").equals(Role.GUEST);
    }
}
