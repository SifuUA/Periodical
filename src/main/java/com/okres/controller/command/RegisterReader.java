package com.okres.controller.command;

import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.ReaderService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.nonNull;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class RegisterReader implements Command {
    private static Logger logger = Logger.getLogger(RegisterReader.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ReaderService readerService = new ReaderService();
        ServletUtility servletUtility = new ServletUtility();
        String firstName = new String(request.getParameter("fname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String lastName = new String(request.getParameter("lname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = new String(request.getParameter("password").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        if (nonNull(phoneNumber) && nonNull(email)) {
            Reader reader = new Reader(servletUtility.checkField(firstName), servletUtility.checkField(lastName),
                    servletUtility.checkField(phoneNumber), servletUtility.checkField(email), servletUtility.checkField(password), Role.READER);
            logger.info("Information for register reader: " + reader);
            if (!readerService.readerIsRegistred(reader))
                readerService.createReader(reader);
        }
        return "redirect: home";
    }
}
