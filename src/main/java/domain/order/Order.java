package domain.order;


import domain.menu.Menu;



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

    public int getChickenCount() {
        if (menu.isChicken()) {
            return count;
        }
        return 0;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + count + " " + getPrice();
    }
}
