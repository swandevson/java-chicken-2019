package Controller;

import Validator.InputValidator;
import domain.Bill;
import domain.Payment;
import domain.Table;
import domain.TableOrders;
import domain.TableRepository;
import view.InputView;
import view.OutputView;



public class PayController {
    private final static double CASH_DISCOUNT_RATIO = 0.5;


    protected void process(TableOrders tableOrders) {
        final int tableNumber = selectTable();

        String billDetails = tableOrders.getBillDetails(tableNumber);
        OutputView.printBillDetails(billDetails);

        final int paymentNumber = selectPayment(tableNumber);
        computeTotalMoney(tableOrders, tableNumber, paymentNumber);
    }


    private int selectTable() {
        final int tableNumber = InputView.inputTableNumber();
        InputValidator.validateTableNumber(tableNumber);

        return tableNumber;
    }

    private int selectPayment(int tableNumber) {
        final int paymentNumber = InputView.inputPaymentNumber(tableNumber);
        InputValidator.validatePayment(paymentNumber);

        return paymentNumber;
    }

    private int computeTotalMoney(TableOrders tableOrders, int tableNumber, int paymentNumber) {
        Table table = TableRepository.getTable(tableNumber);
        int totalMoney = tableOrders.computeTotalMoney(tableNumber);

        if (Payment.CASH.equals(paymentNumber)) {
            totalMoney = (int)(totalMoney - (totalMoney * CASH_DISCOUNT_RATIO));
        }

        table.pay();

        return totalMoney;
    }
}
