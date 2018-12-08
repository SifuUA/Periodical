package com.okres.model.entity;

import com.okres.model.entity.enums.Gender;
import com.okres.model.entity.enums.Role;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private int id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private Gender gender;
    private Timestamp date;
    private String emailAddress;
    private String password;
    private Role role;

    private List<Edition> editionList = new ArrayList<>();
    private List<Payment> paymentList = new ArrayList<>();

    public Reader() {
    }

    public Reader(int id, String firstName, String lastName, int phoneNumber, Gender gender, Timestamp date,
                  String emailAddress, String password, Role role, List<Edition> editionList, List<Payment> paymentList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.date = date;
        this.emailAddress = emailAddress;
        this.password = password;
        this.role = role;
        this.editionList = editionList;
        this.paymentList = paymentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Edition> getEditionList() {
        return editionList;
    }

    public void setEditionList(List<Edition> editionList) {
        this.editionList = editionList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                ", date=" + date +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", editionList=" + editionList +
                ", paymentList=" + paymentList +
                '}';
    }
}
