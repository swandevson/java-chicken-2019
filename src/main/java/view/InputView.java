package view;

import domain.Command;
import domain.MenuRepository;
import domain.TableRepository;
import java.util.Arrays;
import java.util.Scanner;



public class InputView {

    private static final Scanner scanner = new Scanner(System.in);


    public static int inputCommandNumber() {
        System.out.println("## 메인화면");
        Arrays.stream(Command.values())
                .forEach(System.out::println);
        System.out.println();

        System.out.println("## 원하는 기능을 선택하세요.");

        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println();
        OutputView.printTables(TableRepository.tables());

        System.out.println("##테이블을 선택하세요.");

        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println();
        OutputView.printMenus(MenuRepository.menus());
        System.out.println();

        System.out.println("## 등록할 메뉴를 선택하세요.");

        return scanner.nextInt();
    }

    public static int inputMenuCount() {
        System.out.println();
        System.out.println("## 메뉴의 수량을 입력하세요.");

        return scanner.nextInt();
    }

    public static int inputPaymentNumber() {
        System.out.println("## 신용 카드는 1번, 현금은 2번");

        return scanner.nextInt();
    }
}
