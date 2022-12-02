package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Bill {
    private final List<Order> orders;


    public Bill() {
        this.orders = new ArrayList<>();
    }


    public void addOrder(Order order) {
        orders.add(order);
    }
}
