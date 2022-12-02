package Controller;


import domain.Payment;
import domain.Table;
import domain.TableOrders;
import domain.repository.TableRepository;

import view.InputView;
import view.OutputView;



public class PayController {
    private final static double CASH_DISCOUNT_RATIO = 0.05;

    protected void process(final TableOrders tableOrders) {
        final Table table = selectTable();

        if (!table.isOrdered()) {
            throw new IllegalArgumentException("주문 내역이 없는 테이블입니다");
        }

        final Payment payment = getPayment(tableOrders, table);

        int totalMoney = computeTotalMoney(tableOrders, table, payment);
        OutputView.printTotalMoney(totalMoney);
    }

    private void showBillDetails(final TableOrders tableOrders, final Table table) {
        String billDetails = tableOrders.getBillDetails(table);

        OutputView.printBillDetails(billDetails);
    }

    private Payment getPayment(final TableOrders tableOrders, final Table table) {
        showBillDetails(tableOrders, table);

        OutputView.printPayTable(table);
        final Payment payment = selectPayment();

        return payment;
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

    private int computeTotalMoney(final TableOrders tableOrders, final Table table, final Payment payment) {
        int totalMoney = tableOrders.computeTotalMoney(table);

        if (payment.equals(Payment.CASH)) {
            totalMoney = (int) (totalMoney - (totalMoney * CASH_DISCOUNT_RATIO));
        }

        tableOrders.clear(table);

        return totalMoney;
    }
}
