package Controller;

import Validator.InputValidator;
import domain.MenuRepository;
import domain.Order;
import domain.TableOrders;
import view.InputView;



public class OrderController {

    protected void process(TableOrders tableOrders) {
        final int tableNumber = selectTable();
        final int menuNumber = selectMenu();
        final int menuCount = inputMenuCount();
        Order order = new Order(MenuRepository.getMenu(menuNumber), menuCount);

        tableOrders.addOrder(tableNumber, order);
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

    private int selectMenu() {
        while (true) {
            try {
                final int menuNumber = InputView.inputMenuNumber();
                InputValidator.validateMenuNumber(menuNumber);

                return menuNumber;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int inputMenuCount() {
        while (true) {
            try {
                int menuCount = InputView.inputMenuCount();
                InputValidator.validateMenuCount(menuCount);

                return menuCount;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
