package Controller;

import Validator.InputValidator;
import domain.Bill;
import domain.TableOrders;
import view.InputView;



public class PayController {
    protected void process(TableOrders tableOrders) {
        int tableNumber = selectTable();
        InputValidator.validatePay(tableNumber);


    }

    private int selectTable() {
        final int tableNumber = InputView.inputTableNumber();
        InputValidator.validateTableNumber(tableNumber);

        return tableNumber;
    }
}
