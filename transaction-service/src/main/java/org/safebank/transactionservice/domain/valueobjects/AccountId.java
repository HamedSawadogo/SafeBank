package org.safebank.transactionservice.domain.valueobjects;


public record AccountId(String id) {
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AccountId) {
            return id.equals(((AccountId) obj).id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
