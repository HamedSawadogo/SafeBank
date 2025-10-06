package org.safebank.transactionservice.domain.models;

public class ConsumerPreview {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Account account;

    public ConsumerPreview(Account account, String email, String lastName, String firstName, String id) {
        this.account = account;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    public ConsumerPreview() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
