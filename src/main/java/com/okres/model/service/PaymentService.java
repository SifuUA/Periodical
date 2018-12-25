package com.okres.model.service;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.PaymentDao;
import com.okres.model.entity.Payment;

import java.sql.SQLException;

public class PaymentService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void registerPayment(Payment payment) {
        PaymentDao paymentDao = daoFactory.createPaymentDao();
        try {
            paymentDao.create(payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
