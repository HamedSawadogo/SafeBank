package org.safebank.consumersservice.domain.models;

import org.safebank.consumersservice.domain.valueobjects.ConsumerId;
import java.util.List;

public class Consumer {
    private ConsumerId consumerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String country;
    private List<AccountPreview> accounts;

    public Consumer(ConsumerId consumerId, String firstName, String lastName, String email, String phoneNumber, String country, List<AccountPreview> accounts) {
        this.consumerId = consumerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.accounts = accounts;
    }

    public Consumer() {
    }

    public ConsumerId getConsumerId() {
        return consumerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
