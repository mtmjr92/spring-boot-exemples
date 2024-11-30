package br.com.basic_architecture.util.validation;

import br.com.basic_architecture.util.validation.exception.BadRequestException;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic validator that applies validation rules to an object of type T.
 *
 * @param <T> the type of the object to be validated
 */
public class Validator<T> {

    /**
     * A list to hold validation error messages.
     */
    private final List<String> errors = new ArrayList<>();

    /**
     * The combined validation rule to be applied to the object.
     */
    private ValidationRule<T> combinedRule;

    /**
     * Private constructor to create a Validator instance with the specified initial rule.
     *
     * @param initialRule the initial validation rule to be applied
     */
    private Validator(ValidationRule<T> initialRule) {
        combinedRule = initialRule;
    }

    /**
     * Creates a new instance of {@link Validator} with the specified initial validation rule.
     *
     * @param initialRule the initial validation rule to be applied
     * @param <T>         the type of the object to be validated
     * @return a new instance of {@link Validator}
     */
    public static <T> Validator<T> of(ValidationRule<T> initialRule) {
        return new Validator<>(initialRule);
    }

    /**
     * Validates the given object against the combined validation rules.
     *
     * @param object the object to be validated
     * @return the current instance of {@link Validator} for method chaining
     */
    public Validator<T> validate(T object) {
        ValidationResult result = combinedRule.validate(object);

        if (!result.isValid()) {
            errors.add(result.getErrorMessage());
        }

        return this;
    }

    /**
     * Throws a {@link BadRequestException} if any validation errors were encountered.
     *
     * @throws BadRequestException if validation fails
     */
    public void throwIfInvalid() {
        if (!errors.isEmpty()) {
            throw new BadRequestException(errors.getFirst());
        }
    }

    /**
     * Combines this validator with another validation rule using logical AND.
     *
     * @param rule the validation rule to combine with
     * @return the current instance of {@link Validator} for method chaining
     */
    public Validator<T> and(ValidationRule<T> rule) {
        combinedRule = combinedRule.and(rule);
        return this;
    }

    /**
     * Combines this validator with another validation rule using logical OR.
     *
     * @param rule the validation rule to combine with
     * @return the current instance of {@link Validator} for method chaining
     */
    public Validator<T> or(ValidationRule<T> rule) {
        combinedRule = combinedRule.or(rule);
        return this;
    }

}
