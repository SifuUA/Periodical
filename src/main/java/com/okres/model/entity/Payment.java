package com.okres.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private int paymentAmmount;
    private boolean approve;
    private Reader reader;
    private List<Edition> editionList = new ArrayList<>();

    public Payment() {
    }

    public Payment(int paymentAmmount, boolean approve, Reader reader, List<Edition> editionList) {
        this.paymentAmmount = paymentAmmount;
        this.approve = approve;
        this.reader = reader;
        this.editionList = editionList;
    }

    public int getPaymentAmmount() {
        return paymentAmmount;
    }

    public void setPaymentAmmount(int paymentAmmount) {
        this.paymentAmmount = paymentAmmount;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public List<Edition> getEditionList() {
        return editionList;
    }

    public void setEditionList(List<Edition> editionList) {
        this.editionList = editionList;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentAmmount=" + paymentAmmount +
                ", approve=" + approve +
                ", reader=" + reader +
                ", editionList=" + editionList +
                '}';
    }
}
