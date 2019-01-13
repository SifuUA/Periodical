package com.okres.model.service;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.PaymentDao;
import com.okres.model.entity.Payment;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class PaymentService {
    private Logger logger = Logger.getLogger(PaymentService.class);
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void registerPayment(Payment payment) {
        try (PaymentDao paymentDao = daoFactory.createPaymentDao()) {
            paymentDao.create(payment);
        } catch (SQLException e) {
            logger.error("Cant create payment: " + e);
        }
    }

    public void confirm(List<String> payment) {
        try (PaymentDao paymentDao = daoFactory.createPaymentDao()) {
            paymentDao.confirmSubscription(payment.get(0), payment.get(1), payment.get(3));
        }
    }
}
