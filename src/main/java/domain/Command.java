package domain;



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


    public int getNumber() {
        return number;
    }

    public String getStatement() {
        return statement;
    }


    @Override
    public String toString() {
        return number + " - " + statement;
    }
}
