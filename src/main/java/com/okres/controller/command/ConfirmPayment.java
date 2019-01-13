package com.okres.controller.command;

import com.okres.model.service.PaymentService;
import com.okres.model.service.ReaderService;
import org.apache.log4j.Logger;

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

public class ConfirmPayment implements Command {
    private static Logger logger = Logger.getLogger(ConfirmPayment.class);
    private ReaderService readerService;
    private PaymentService paymentService;

    public ConfirmPayment(ReaderService readerService, PaymentService paymentService) {
        this.readerService = readerService;
        this.paymentService = paymentService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int index = Integer.parseInt(request.getParameter("item"));

        Map<Integer, List<String>> tmpMap =
                (Map<Integer, List<String>>) request.getSession().getAttribute("readersPayments");
        logger.debug("Index of edition for payment: " + index);
        List<String> tmpList = tmpMap.get(index);
        paymentService.confirm(tmpList);
        Map<Integer, List<String>> readersPayments = readerService.getReadersPayments();
        request.getSession().setAttribute("readersPayments", readersPayments);
        return "/WEB-INF/views/viewReadersSubscriptionsByAdmin.jsp";
    }
}
