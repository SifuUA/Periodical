package com.okres.model.entity;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class Edition {
    private int id;
    private String editionName;
    private int category;
    private Blob image;
    private int price;
    private String notation;
    private List<Reader> readersList = new ArrayList<>();
    private List<Payment> paymentsList = new ArrayList<>();

    public Edition() {
    }

    public Edition(int id, String editionName, int category, Blob image, int price, String notation, List<Reader> readersList,
                   List<Payment> paymentsList) {
        this.id = id;
        this.editionName = editionName;
        this.category = category;
        this.image = image;
        this.price = price;
        this.notation = notation;
        this.readersList = readersList;
        this.paymentsList = paymentsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Reader> getReadersList() {
        return readersList;
    }

    public void setReadersList(List<Reader> readersList) {
        this.readersList = readersList;
    }

    public List<Payment> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payment> paymentsList) {
        this.paymentsList = paymentsList;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", editionName='" + editionName + '\'' +
                ", category=" + category +
                ", image=" + image +
                ", price=" + price +
                ", notation='" + notation + '\'' +
                ", readersList=" + readersList +
                ", paymentsList=" + paymentsList +
                '}';
    }
}