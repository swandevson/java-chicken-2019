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


    public void addOrder(Table table, Order order) {
        Bill bill = tableOrders.get(table);

        table.order();

        bill.addOrder(order);
    }

    public String getBillDetails(Table table) {
        Bill bill = tableOrders.get(table);

        return bill.toString();
    }

    public int computeTotalMoney(Table table) {
        Bill bill = tableOrders.get(table);

        return bill.computeTotalMoney();
    }
}
