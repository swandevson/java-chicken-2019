package Controller;

import Validator.InputValidator;

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
        int totalMoney = computeTotalMoney(tableOrders, tableNumber, paymentNumber);

        OutputView.printTotalMoney(totalMoney);
    }


    private int selectTable() {
        while (true) {
            try {
                final int tableNumber = InputView.inputTableNumber();
                InputValidator.validateTableNumber(tableNumber);

                return tableNumber;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }

    }

    private int selectPayment(int tableNumber) {
        while (true) {
            try {
                final int paymentNumber = InputView.inputPaymentNumber(tableNumber);
                InputValidator.validatePayment(paymentNumber);

                return paymentNumber;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int computeTotalMoney(TableOrders tableOrders, int tableNumber, int paymentNumber) {
        Table table = TableRepository.getTable(tableNumber);
        int totalMoney = tableOrders.computeTotalMoney(tableNumber);

        if (Payment.CASH.equals(paymentNumber)) {
            totalMoney = (int) (totalMoney - (totalMoney * CASH_DISCOUNT_RATIO));
        }

        table.pay();

        return totalMoney;
    }
}
