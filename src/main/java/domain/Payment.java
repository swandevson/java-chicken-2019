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

    public boolean equals(int number) {
        return this.number == number;
    }

    public static Payment getPayment(int number) {
        return Arrays.stream(Payment.values())
                .filter(payment -> payment.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 결제수단입니다."));
    }
}
