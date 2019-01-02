package com.okres.model.service;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.PaymentDao;
import com.okres.model.entity.Payment;

import java.sql.SQLException;
import java.util.List;

public class PaymentService {

    DaoFactory daoFactory = DaoFactory.getInstance();


    public void registerPayment(Payment payment) {

        try (PaymentDao paymentDao = daoFactory.createPaymentDao()) {

            paymentDao.create(payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void confirm(List<String> payment) {
        try (PaymentDao paymentDao = daoFactory.createPaymentDao()) {
            paymentDao.confirmSubscription(payment.get(0), payment.get(1), payment.get(3));
        }
    }
}
