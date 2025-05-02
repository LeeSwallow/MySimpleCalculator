package level3;

import java.util.Scanner;

public class App {
    private static boolean isDouble(Number number) {
        return number instanceof Double;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        boolean isContinue = true;

        while (isContinue) {
            boolean hasDouble;

            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                Number num1 = InputParser.parseNumber(sc.nextLine());
                hasDouble = isDouble(num1);

                System.out.print("두 번째 숫자를 입력하세요: ");
                Number num2 = InputParser.parseNumber(sc.nextLine());
                hasDouble |= isDouble(num2);

                System.out.print("사칙연산 기호를 입력하세요: ");
                OperatorType operator = InputParser.parseOperator(sc.nextLine());

                if (hasDouble) {
                    Double result = calculator.calculate(num1.doubleValue(), num2.doubleValue(), operator);
                    System.out.println("결과: " + result);
                } else {
                    Integer result = calculator.calculate(num1.intValue(), num2.intValue(), operator);
                    System.out.println("결과: " + result);
                }

            } catch(Exception e) {
                System.out.println("에러발생 : " + e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (InputParser.ParseEndInput(sc.nextLine())) {
                isContinue = false;
                sc.close();
            }
        }
    }
}
