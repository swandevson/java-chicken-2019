package Validator;

import static org.junit.jupiter.api.Assertions.*;

import domain.Command;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.EnumOptions;



class InputValidatorTest {

    @ParameterizedTest
    @EnumSource(value = Command.class)
    void 올바른_명령어_번호_입력(Command command) {
        int commandNumber = command.getNumber();

        assertDoesNotThrow(() ->
                InputValidator.validateCommandNumber(commandNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 4, 10})
    void 예외_명령어_번호_입력(int number) {
        assertThrowsExactly(IllegalArgumentException.class,
                () -> InputValidator.validateCommandNumber(number));
    }
}