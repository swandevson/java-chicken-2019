package Controller;

import Validator.InputValidator;
import domain.Bill;
import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Table;
import domain.TableOrders;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;



public class OrderController {

    protected void process(TableOrders tableOrders) {
        final int tableNumber = selectTable();
        final int menuNumber = selectMenu();
        final int menuCount = inputMenuCount();
        Order order = new Order(MenuRepository.getMenu(menuNumber), menuCount);

        tableOrders.addOrder(tableNumber, order);
    }

    private int selectTable() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        InputValidator.validateTableNumber(tableNumber);

        return tableNumber;
    }

    private int selectMenu() {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenuNumber();
        InputValidator.validateMenuNumber(menuNumber);

        return menuNumber;
    }

    private int inputMenuCount() {
        final int menuCount = InputView.inputMenuCount();
        InputValidator.validateMenuCount(menuCount);

        return menuCount;
    }
}
