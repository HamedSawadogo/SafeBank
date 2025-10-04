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
