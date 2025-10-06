package org.safebank.transactionservice.application.ports;

import org.safebank.transactionservice.domain.models.ConsumerPreview;

public interface AuthenticationPort {
    ConsumerPreview getAuthenticatedConsumer();
}
