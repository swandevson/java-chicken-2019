package domain;

public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean equals(int number) {
        return this.number == number;
    }
}
