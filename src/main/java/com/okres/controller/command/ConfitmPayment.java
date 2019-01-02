package com.okres.controller.command;

import com.okres.model.entity.Reader;
import com.okres.model.service.PaymentService;
import com.okres.model.service.ReaderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ConfitmPayment implements Command {

    private ReaderService readerService;
    private PaymentService paymentService;

    public ConfitmPayment(ReaderService readerService, PaymentService paymentService) {
        this.readerService = readerService;
        this.paymentService = paymentService;
    }

    public ConfitmPayment(ReaderService readerService) {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //ReaderService readerService = new ReaderService();
        int index = Integer.parseInt(request.getParameter("item"));

        Map<Integer, List<String>> tmpMap =
                (Map<Integer, List<String>>) request.getSession().getAttribute("readersPayments");
        System.out.println("Index " + index);
        List<String> tmpList = tmpMap.get(index);
        paymentService.confirm(tmpList);


        Map<Integer, List<String>> readersPayments = readerService.getReadersPayments();
        request.getSession().setAttribute("readersPayments", readersPayments);

        return "/WEB-INF/views/viewReadersSubscriptionsByAdmin.jsp";
    }
}
