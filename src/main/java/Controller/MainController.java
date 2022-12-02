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
    public void run() {
        final int commandNumber = InputView.inputCommandNumber();
        InputValidator.validateCommandNumber(commandNumber);

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
