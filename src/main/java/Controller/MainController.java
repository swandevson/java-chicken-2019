package Controller;

import Validator.InputValidator;

import domain.Command;
import domain.TableOrders;

import view.InputView;



public class MainController {
    final private OrderController orderController = new OrderController();
    final private PayController payController = new PayController();
    final private TableOrders tableOrders = new TableOrders();


    public void run() {
        while (true) {
            try {
                final int commandNumber = InputView.inputCommandNumber();
                final Command command = Command.getCommand(commandNumber);

                if (command.equals(Command.ORDER)) {
                    order();
                }

                if (command.equals(Command.PAY)) {
                    pay();
                }

                if (command.equals(Command.QUIT)) {
                    return;
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void order() {
        orderController.process(tableOrders);
    }

    private void pay() {
        payController.process(tableOrders);
    }
}
