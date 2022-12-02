package domain;

public class Table {
    private final int number;
    private boolean ordered;

    public Table(final int number) {
        this.number = number;
        this.ordered = false;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean equals(int number) {
        return this.number == number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public String getTableMark() {
        if (ordered) {
            return "O";
        }

        return "─";
    }

    public void pay() {
        ordered = false;
    }

    public void order() {
        ordered = true;
    }
}
