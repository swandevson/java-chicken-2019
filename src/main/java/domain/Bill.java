package domain;

import java.util.ArrayList;
import java.util.List;



public class Bill {
    private static final int DISCOUNT_UNIT = 10;
    private static final int DISCOUNT_MONEY = 10000;

    private final List<Order> orders;


    public Bill() {
        this.orders = new ArrayList<>();
    }


    public void addOrder(Order order) {
        orders.add(order);
    }

    public int computeTotalMoney() {
        int totalMoney = 0;
        int chickenCount = 0;

        for (Order order : orders) {
            totalMoney += order.getPrice();
            chickenCount += order.getChickenCount();
        }

        return totalMoney - ((chickenCount / DISCOUNT_UNIT) * DISCOUNT_MONEY);
    }

    @Override
    public String toString() {
        String billDetails = "";
        for (Order order : orders) {
            billDetails += order.toString() + System.lineSeparator();
        }

        return billDetails;
    }
}
