package com.okres.model.entity;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class Edition {
    private String editionName;
    private Category category;
    private Blob image;
    private int price;
    private List<Reader> readersList = new ArrayList<>();
    private List<Payment> paymentList = new ArrayList<>();

    public Edition() {
    }

    public Edition(String editionName, Category category, Blob image, int price, List<Reader> readersList, List<Payment> paymentList) {
        this.editionName = editionName;
        this.category = category;
        this.image = image;
        this.price = price;
        this.readersList = readersList;
        this.paymentList = paymentList;
    }

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "editionName='" + editionName + '\'' +
                ", category=" + category +
                ", image=" + image +
                ", price=" + price +
                ", readersList=" + readersList +
                ", paymentList=" + paymentList +
                '}';
    }
}