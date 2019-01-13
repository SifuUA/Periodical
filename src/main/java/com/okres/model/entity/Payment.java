package com.okres.model.entity;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class Payment {
    private int id;
    private int paymentAmmount;
    private boolean approve;
    private int reader_id;
    private int edition_id;

    public Payment() {
    }

    public Payment(int id, int paymentAmmount, boolean approve, int reader_id, int edition_id) {
        this.id = id;
        this.paymentAmmount = paymentAmmount;
        this.approve = approve;
        this.reader_id = reader_id;
        this.edition_id = edition_id;
    }

    public Payment(int paymentAmmount, boolean approve, int reader_id, int edition_id) {
        this.paymentAmmount = paymentAmmount;
        this.approve = approve;
        this.reader_id = reader_id;
        this.edition_id = edition_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public int getEdition_id() {
        return edition_id;
    }

    public void setEdition_id(int edition_id) {
        this.edition_id = edition_id;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentAmmount=" + paymentAmmount +
                ", approve=" + approve +
                ", reader_id=" + reader_id +
                ", edition_id=" + edition_id +
                '}';
    }
}
