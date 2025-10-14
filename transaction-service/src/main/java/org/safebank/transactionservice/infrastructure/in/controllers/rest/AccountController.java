package org.safebank.transactionservice.infrastructure.in.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.safebank.transactionservice.application.usecases.deposit.DepositUseCase;
import org.safebank.transactionservice.domain.valueobjects.AccountId;
import org.safebank.transactionservice.domain.valueobjects.Amount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final DepositUseCase depositUseCase;

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Amount> deposit(@PathVariable final String id,
                                          @RequestBody  final Amount amount) {
        return ResponseEntity.ok().body(depositUseCase.handle(new AccountId(id), amount.amount()));
    }
}
