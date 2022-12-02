package domain;

public class Order {
    final private Menu menu;
    final private int count;


    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public int getPrice() {
        return menu.getPrice() * count;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + count + " " + getPrice();
    }
}
