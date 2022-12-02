package domain;

import java.util.Arrays;



public enum Payment {
    CARD(1),
    CASH(2);


    private final int number;


    Payment(int number) {
        this.number = number;
    }


    public static boolean isExistPayment(int number) {
        return Arrays.stream(Payment.values())
                .anyMatch(payment -> payment.number == number);
    }
}
