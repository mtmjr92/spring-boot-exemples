package br.com.basic_architecture.web.rest.v1.login;

import br.com.basic_architecture.dto.LoginDto;
import br.com.basic_architecture.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final LoginService service;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDto login) {
        return ResponseEntity.ok(service.login(login));
    }

}
