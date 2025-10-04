package org.safebank.consumersservice.domain.valueobjects;


public record ConsumerId (String consumerId) {
    @Override
    public String toString() {
        return consumerId;
    }
}
