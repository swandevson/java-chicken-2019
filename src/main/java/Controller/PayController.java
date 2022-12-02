package Controller;


import domain.Payment;
import domain.Table;
import domain.TableOrders;
import domain.TableRepository;

import view.InputView;
import view.OutputView;



public class PayController {
    private final static double CASH_DISCOUNT_RATIO = 0.5;


    protected void process(TableOrders tableOrders) {
        final Table table = selectTable();

        String billDetails = tableOrders.getBillDetails(table);
        OutputView.printBillDetails(billDetails);

        OutputView.printPayTable(table);
        final Payment payment = selectPayment();

        int totalMoney = computeTotalMoney(tableOrders, table, payment);
        OutputView.printTotalMoney(totalMoney);
    }


    private Table selectTable() {
        while (true) {
            try {
                final int tableNumber = InputView.inputTableNumber();

                return TableRepository.getTable(tableNumber);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }

    }

    private Payment selectPayment() {
        while (true) {
            try {
                final int paymentNumber = InputView.inputPaymentNumber();

                return Payment.getPayment(paymentNumber);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int computeTotalMoney(TableOrders tableOrders, Table table, Payment payment) {
        int totalMoney = tableOrders.computeTotalMoney(table);

        if (payment.equals(Payment.CASH)) {
            totalMoney = (int) (totalMoney - (totalMoney * CASH_DISCOUNT_RATIO));
        }

        tableOrders.clear(table);

        return totalMoney;
    }
}
