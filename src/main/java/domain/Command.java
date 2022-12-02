package domain;


import java.util.Arrays;



public enum Command {
    ORDER(1, "주문등록"),
    PAY(2, "결제하기"),
    QUIT(3, "프로그램 종료");


    private final int number;
    private final String statement;


    Command(int number, String statement) {
        this.number = number;
        this.statement = statement;
    }


    public static Command getCommand(int number) {
        return Arrays.stream(Command.values())
                .filter(command -> command.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 명령어입니다."));
    }

    @Override
    public String toString() {
        return number + " - " + statement;
    }
}
