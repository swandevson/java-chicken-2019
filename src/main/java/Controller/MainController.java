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
            final int commandNumber = InputView.inputCommandNumber();
            Command command = Command.getCommand(commandNumber);

            if (command.equals(Command.ORDER)) {
                order();
            }

            if (command.equals(Command.PAY)) {
                pay();
            }

            if (command.equals(Command.QUIT)) {
                return;
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
