package Controller;

import Validator.InputValidator;
import domain.Command;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableOrders;
import domain.TableRepository;
import java.util.HashMap;
import java.util.List;
import view.InputView;
import view.OutputView;



public class MainController {
    final private OrderController orderController = new OrderController();
    final private TableOrders tableOrders = new TableOrders();


    public void run() {
        final int commandNumber = InputView.inputCommandNumber();
        InputValidator.validateCommandNumber(commandNumber);

        if (Command.ORDER.equals(commandNumber)) {
            order();
        }
    }

    private void order() {
        orderController.process(tableOrders);
    }
}
