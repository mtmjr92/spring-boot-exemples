package br.com.basic_architecture.service;

import br.com.basic_architecture.dto.LoginDto;
import br.com.basic_architecture.util.validation.Validator;
import br.com.basic_architecture.web.rest.v1.login.LoginValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final LoginValidation loginValidation;

    public String login(LoginDto loginDto) {
        validate(loginDto);

        return "ok";
    }

    private void validate(LoginDto loginDto) {
        Validator.of(loginValidation.validationUserIsNull())
                .and(loginValidation.validationUserPassword())
                .validate(loginDto)
                .throwIfInvalid();
    }

}
