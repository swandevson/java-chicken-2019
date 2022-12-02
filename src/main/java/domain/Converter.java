package domain;

public class Converter {
    public static int toInteger(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("존재하는 명령어만 입력해 주세요");
        }
    }
}
