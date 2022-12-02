package Validator;


import domain.Command;
import domain.MenuRepository;
import domain.TableRepository;
import java.util.Arrays;



public class InputValidator {
    private static final int MAX_MENU_COUNT = 99;


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

    public static void validateMenuNumber(int number) throws IllegalArgumentException {
        if (!MenuRepository.isExistMenu(number)) {
            throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
        }
    }

    public static void validateMenuCount(int count) throws IllegalArgumentException {
        if (count <= 0) {
            throw new IllegalArgumentException("최소 1개는 주문해야합니다.");
        }

        if (count > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("너무 많은 주문량입니다");
        }
    }
}
