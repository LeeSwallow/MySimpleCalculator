package level3;

import java.util.HashMap;
import java.util.Scanner;

public class InputParser {
    final static private HashMap<Character, OperatorType> validOperators;
    static {
        validOperators = new HashMap<>();
        validOperators.put('+', OperatorType.ADD);
        validOperators.put('-', OperatorType.SUBTRACT);
        validOperators.put('*', OperatorType.MULTIPLY);
        validOperators.put('/', OperatorType.DIVIDE);
    }

    public static OperatorType parseOperator(String input) throws RuntimeException {
        char operator = input.charAt(0);
        if (!validOperators.containsKey(operator)) {
            throw new RuntimeException("지원하지 않는 연산자 입니다.");
        }
        return validOperators.get(operator);
    }

    public static Number parseNumber(String input) throws RuntimeException {
        try(Scanner scanner = new Scanner(input)) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                throw new RuntimeException("제대로 된 형식의 숫자를 입력해 주세요!");
            }
        }
    }

    public static boolean ParseEndInput(String input) {
        return input.trim().equalsIgnoreCase("exit");
    }
}
