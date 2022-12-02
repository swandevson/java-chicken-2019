package view;

import Validator.InputValidator;
import domain.Command;
import domain.TableRepository;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCommandNumber() {
        System.out.println("## 메인화면");
        Arrays.stream(Command.values())
                .forEach(System.out::println);

        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        OutputView.printTables(TableRepository.tables());

        return scanner.nextInt();
    }
}
