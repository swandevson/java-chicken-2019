package Validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import domain.Command;
import domain.TableRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 4, 10})
    void 예외_명령어_번호_입력(int number) {
        assertThrowsExactly(IllegalArgumentException.class,
                () -> Command.getCommand(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void 올바른_결제_수단_입력(int number) {
        assertDoesNotThrow(() ->
                TableRepository.getTable(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 5})
    void 예외_결제_수단_입력(int number) {
        assertThrowsExactly(IllegalArgumentException.class,
                () -> TableRepository.getTable(number));
    }
}