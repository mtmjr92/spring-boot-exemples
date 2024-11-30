package br.com.basic_architecture.util.validation;

/**
 * Represents a validation rule for an object of type T.
 *
 * @param <T> the type of the object to be validated
 */
@FunctionalInterface
public interface ValidationRule<T> {

    /**
     * Validates the given object and returns the result of the validation.
     *
     * @param t the object to be validated
     * @return a {@link ValidationResult} indicating whether the validation passed or failed
     */
    ValidationResult validate(T t);

    /**
     * Combines this validation rule with another using a logical AND operation.
     * The combined rule will pass only if both this rule and the other rule pass.
     *
     * @param other the other validation rule to combine with
     * @return a new {@link ValidationRule} that represents the combination of this rule and the other rule
     */
    default ValidationRule<T> and(ValidationRule<T> other) {
        return (T t) -> {
            ValidationResult result = validate(t);

            if (!result.isValid()) {
                return result;
            }

            return other.validate(t);
        };
    }

    /**
     * Combines this validation rule with another using a logical OR operation.
     * The combined rule will pass if either this rule or the other rule passes.
     *
     * @param other the other validation rule to combine with
     * @return a new {@link ValidationRule} that represents the combination of this rule and the other rule
     */
    default ValidationRule<T> or(ValidationRule<T> other) {
        return (T t) -> {
            ValidationResult result = validate(t);

            if (result.isValid()) {
                return result;
            }

            return other.validate(t);
        };
    }

}

