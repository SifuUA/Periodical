package com.okres.model.entity;

import com.okres.model.entity.enums.Category;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class Edition {
    private int id;
    private String editionName;
    private Category category;
    private Blob image;
    private int price;
    private List<Reader> readersList = new ArrayList<>();
    private List<Payment> paymentsList = new ArrayList<>();

    public Edition() {
    }

    public Edition(int id, String editionName, Category category, Blob image, int price, List<Reader> readersList,
                   List<Payment> paymentsList) {
        this.id = id;
        this.editionName = editionName;
        this.category = category;
        this.image = image;
        this.price = price;
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

    public List<Payment> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payment> paymentsList) {
        this.paymentsList = paymentsList;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", editionName='" + editionName + '\'' +
                ", category=" + category +
                ", image=" + image +
                ", price=" + price +
                ", readersList=" + readersList +
                ", paymentsList=" + paymentsList +
                '}';
    }
}