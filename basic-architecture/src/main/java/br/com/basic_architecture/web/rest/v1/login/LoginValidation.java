package br.com.basic_architecture.web.rest.v1.login;

import br.com.basic_architecture.dto.LoginDto;
import br.com.basic_architecture.util.validation.ValidationResult;
import br.com.basic_architecture.util.validation.ValidationRule;
import org.springframework.stereotype.Component;

@Component
public class LoginValidation {

    public ValidationRule<LoginDto> validationUserIsNull() {
        return loginDto -> {
            if (loginDto == null || loginDto.getUser() == null) {
                return ValidationResult.invalid("User must not be null.");
            }

            if (!loginDto.getUser().contains("janela")) {
                return ValidationResult.invalid("User must contain the substring 'janela'.");
            }

            return ValidationResult.valid();
        };
    }

    public ValidationRule<LoginDto> validationUserPassword() {
        return new ValidationRule<LoginDto>() {
            @Override
            public ValidationResult validate(LoginDto loginDto) {
                return ValidationResult.valid();
            }
        };

    }

    public ValidationRule<LoginDto> validar() {
        return new ValidationRule<LoginDto>() {

            @Override
            public ValidationResult validate(LoginDto loginDto) {
                if (loginDto.getUser().isEmpty()) {
                    return ValidationResult.invalid("vazrio");
                }

                return ValidationResult.valid();
            }

        };
    }


}
