package view;

import domain.menu.Menu;
import domain.Table;

import java.util.List;



public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ %s ┘";
    private static final String PAY_TALBE_NUMBER = "## %s번 테이블의 결제를 진행합니다." + System.lineSeparator();
    private static final String TOTAL_MONEY = "%d원";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(BOTTOM_LINE, table.getTableMark());
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printBillDetails(final String billDetails) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        System.out.println(billDetails);
    }

    public static void printTotalMoney(int totalMoney) {
        System.out.println("## 최종 결제할 금액");
        System.out.printf(TOTAL_MONEY, totalMoney);
        System.out.println();
    }

    public static void printPayTable(Table table) {
        System.out.printf(PAY_TALBE_NUMBER, table.toString());
        System.out.println();
    }
}
