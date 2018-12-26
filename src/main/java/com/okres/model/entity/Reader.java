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
    private String phoneNumber;
    private Gender gender;
    private Timestamp birthDate;
    private String emailAddress;
    private String password;
    private Role role;

    private List<Edition> editionsList = new ArrayList<>();
    private List<Payment> paymentsList = new ArrayList<>();

    public Reader() {
    }

    public Reader(int id, String firstName, String lastName, String phoneNumber, Gender gender, Timestamp birthDate,
                  String emailAddress, String password, Role role, List<Edition> editionsList, List<Payment> paymentsList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
        this.password = password;
        this.role = role;
        this.editionsList = editionsList;
        this.paymentsList = paymentsList;
    }

    public Reader(String firstName, String lastName, String phoneNumber, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = email;
        this.password = password;
        this.role = role;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
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

    public List<Edition> getEditionsList() {
        return editionsList;
    }

    public void setEditionsList(List<Edition> editionsList) {
        this.editionsList = editionsList;
    }

    public List<Payment> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payment> paymentsList) {
        this.paymentsList = paymentsList;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", editionsList=" + editionsList +
                ", paymentsList=" + paymentsList +
                '}';
    }
}
