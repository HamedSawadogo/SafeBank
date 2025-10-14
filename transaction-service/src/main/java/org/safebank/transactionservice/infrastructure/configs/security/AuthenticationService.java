package org.safebank.transactionservice.infrastructure.configs.security;

import org.safebank.transactionservice.application.ports.AuthenticationPort;
import org.safebank.transactionservice.domain.models.ConsumerPreview;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements AuthenticationPort  {
    @Override
    public ConsumerPreview getAuthenticatedConsumer() {
        return new ConsumerPreview();
    }
}
