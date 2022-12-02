package Validator;


import domain.Command;
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
}
