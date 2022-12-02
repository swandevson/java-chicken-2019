package Controller;

import Validator.InputValidator;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Table;
import domain.TableOrders;

import domain.TableRepository;
import view.InputView;



public class OrderController {

    protected void process(TableOrders tableOrders) {
        final Table table = selectTable();
        final Menu menu = selectMenu();
        final int menuCount = inputMenuCount();
        Order order = new Order(menu, menuCount);

        tableOrders.addOrder(table, order);
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

    private Menu selectMenu() {
        while (true) {
            try {
                final int menuNumber = InputView.inputMenuNumber();

                return MenuRepository.getMenu(menuNumber);
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
