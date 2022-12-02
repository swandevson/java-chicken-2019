package Validator;


import domain.Command;
import domain.TableRepository;
import java.util.Arrays;



public class InputValidator {
    public static void validateCommandNumber(int number) throws IllegalArgumentException {
        for (Command command : Command.values()) {
            if (command.equals(number)) {
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    public static void validateTableNumber(int number) throws IllegalArgumentException {
        if (!TableRepository.isExistTable(number)) {
            throw new IllegalArgumentException("존재하지 않는 테이블입니다.");
        }
    }
}
