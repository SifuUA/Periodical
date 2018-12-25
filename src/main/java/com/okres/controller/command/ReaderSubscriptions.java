package com.okres.controller.command;

import com.okres.model.service.ReaderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReaderSubscriptions implements Command {
    private ReaderService readerService = new ReaderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer, List<String>> readerPayments = readerService.getReaderPayments(request);
        request.getSession().setAttribute("readerPayments", readerPayments);
        return "/WEB-INF/views/viewReadersSubscription.jsp";
    }
}
