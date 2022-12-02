package Validator;

import domain.Command;



public class InputValidator {
    private static final int MAX_MENU_COUNT = 99;


    public static void validateMenuCount(int count) throws IllegalArgumentException {
        if (count <= 0) {
            throw new IllegalArgumentException("최소 1개는 주문해야합니다.");
        }

        if (count > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("너무 많은 주문량입니다");
        }
    }
}
