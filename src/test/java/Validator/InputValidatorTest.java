package Validator;

import static org.junit.jupiter.api.Assertions.*;

import domain.Command;
import domain.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.EnumOptions;



class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 4, 10})
    void 예외_명령어_번호_입력(int number) {
        assertThrowsExactly(IllegalArgumentException.class,
                () -> InputValidator.validateCommandNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void 올바른_결제_수단_입력(int number) {
        assertDoesNotThrow(() ->
                InputValidator.validatePayment(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 5})
    void 예외_결제_수단_입력(int number) {
        assertThrowsExactly(IllegalArgumentException.class,
                () -> InputValidator.validatePayment(number));
    }
}