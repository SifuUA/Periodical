package com.okres.controller.command;

import com.okres.model.entity.Reader;
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

public class ReaderSubscriptions implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ReaderService readerService = new ReaderService();

        Reader reader = (Reader) request.getSession().getAttribute("reader");
        Map<Integer, List<String>> readerPayments = readerService.getReaderPayments(reader.getId());
        request.getSession().setAttribute("readerPayments", readerPayments);
        return "/WEB-INF/views/viewReadersSubscription.jsp";
    }
}
