package domain;

import java.util.HashMap;



public class TableOrders {
    private final HashMap<Integer, Bill> tableOrders;


    public TableOrders() {
        this.tableOrders = new HashMap<>();
        for (Table table : TableRepository.tables()) {
            tableOrders.put(table.getNumber(), new Bill());
        }
    }


    public void addOrder(int tableNumber, Order order) {
        Bill bill = tableOrders.get(tableNumber);

        bill.addOrder(order);
    }
}
