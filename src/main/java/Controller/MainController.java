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
            InputValidator.validateCommandNumber(commandNumber);

            if (Command.ORDER.equals(commandNumber)) {
                order();
            }

            if (Command.PAY.equals(commandNumber)) {
                pay();
            }

            if (Command.QUIT.equals(commandNumber)) {
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
