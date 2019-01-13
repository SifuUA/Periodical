package com.okres.controller.command;

import com.okres.model.entity.Edition;
import com.okres.model.entity.Payment;
import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.PaymentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class Subscribe implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Role role = (Role) request.getSession().getAttribute("role");

        if (role != null) {
            makePayment(request);
            return "/WEB-INF/views/reader.jsp";
        }
        return "/WEB-INF/views/errorPage.jsp";
    }

    private void makePayment(HttpServletRequest request) {
        PaymentService paymentService = new PaymentService();
        Reader reader;
        Edition edition;
        Payment payment;

        reader = (Reader) request.getSession().getAttribute("reader");
        Map<Edition, String> map = (HashMap<Edition, String>) request.getSession().getAttribute("oneEdition");
        Map.Entry<Edition, String> entry = map.entrySet().iterator().next();
        edition = entry.getKey();
        payment = new Payment(edition.getPrice(), false, reader.getId(), edition.getId());
        List<Payment> paymentListReader = reader.getPaymentsList();
        List<Payment> paymentListEdition = edition.getPaymentsList();
        paymentListReader.add(payment);
        paymentListEdition.add(payment);
        reader.setPaymentsList(paymentListReader);
        edition.setPaymentsList(paymentListEdition);
        paymentService.registerPayment(payment);
        request.getSession().setAttribute("reader", reader);
        request.getSession().setAttribute("edition", edition);
        request.getSession().setAttribute("payment", payment);
        request.getSession().setAttribute("paymentList", paymentListReader);
    }
}
