package domain;

import java.util.HashMap;



public class TableOrders {
    private final HashMap<Table, Bill> tableOrders;


    public TableOrders() {
        this.tableOrders = new HashMap<>();
        for (Table table : TableRepository.tables()) {
            tableOrders.put(table, new Bill());
        }
    }


    public void addOrder(int tableNumber, Order order) {
        Table table = TableRepository.getTable(tableNumber);
        Bill bill = tableOrders.get(table);

        table.order();

        bill.addOrder(order);
    }

    public String getBillDetails(int tableNumber) {
        Table table = TableRepository.getTable(tableNumber);
        Bill bill = tableOrders.get(table);

        return bill.toString();
    }

    public int computeTotalMoney(int tableNumber) {
        Table table = TableRepository.getTable(tableNumber);
        Bill bill = tableOrders.get(table);

        return bill.computeTotalMoney();
    }
}
