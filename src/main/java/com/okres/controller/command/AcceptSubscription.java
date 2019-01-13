package com.okres.controller.command;

import com.okres.model.service.ReaderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class AcceptSubscription implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ReaderService readerService = new ReaderService();

        Map<Integer, List<String>> readersPayments = readerService.getReadersPayments();
        request.getSession().setAttribute("readersPayments", readersPayments);
        return "/WEB-INF/views/viewReadersSubscriptionsByAdmin.jsp";
    }
}
