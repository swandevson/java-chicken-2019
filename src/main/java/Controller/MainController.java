package Controller;

import Validator.InputValidator;
import domain.Command;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;



public class MainController {
    private OrderController orderController = new OrderController();


    public void run() {
        final int commandNumber = InputView.inputCommandNumber();
        InputValidator.validateCommandNumber(commandNumber);

        if (Command.ORDER.equals(commandNumber)) {
            order();
        }
    }

    private void order() {
        orderController.process();
    }
}
