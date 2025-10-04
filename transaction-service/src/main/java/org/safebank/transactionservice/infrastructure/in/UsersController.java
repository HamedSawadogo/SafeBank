package org.safebank.transactionservice.infrastructure.in;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UsersController {

    private final AuthenticationManager authenticationManager;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok().body("hello world");
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody final AuthRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.userName,
                request.password
        );
        SecurityContextHolder.getContext();
        authenticationManager.authenticate(authenticationToken);
        return ResponseEntity.ok().body("TOKEN");
    }

    @Getter
    class AuthRequest {
        String userName;
        String password;
    }
}
