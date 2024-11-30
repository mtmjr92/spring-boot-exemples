package br.com.basic_architecture.util.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents the result of a validation process.
 */
@Getter
@RequiredArgsConstructor
public class ValidationResult {

    /**
     * Indicates whether the validation passed or failed.
     */
    private final boolean valid;

    /**
     * Contains an error message if the validation failed.
     */
    private final String errorMessage;

    /**
     * Creates a valid {@link ValidationResult}.
     *
     * @return a new instance of {@link ValidationResult} representing a valid result.
     */
    public static ValidationResult valid() {
        return new ValidationResult(true, null);
    }

    /**
     * Creates an invalid {@link ValidationResult} with the specified error message.
     *
     * @param errorMessage the error message describing the validation failure.
     * @return a new instance of {@link ValidationResult} representing an invalid result.
     */
    public static ValidationResult invalid(String errorMessage) {
        return new ValidationResult(false, errorMessage);
    }

}
