package level2;

import java.util.Scanner;

public class App {

    private static int parseNaturalNumber(String userInput) throws RuntimeException  {
        try (Scanner scanner = new Scanner(userInput)) {
            int number;
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            } else {
                throw new RuntimeException("제대로 된 형식의 숫자를 입력해 주세요!");
            }
            if (number <= 0) throw new RuntimeException("양의 정수를 입력해 주세요!");
            return number;
        }
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        boolean isContinue = true;

        while (isContinue) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요:");
                String userInput = sc.nextLine();
                int num1 = parseNaturalNumber(userInput);

                System.out.print("두 번째 숫자를 입력하세요:");
                sc.nextLine();
                int num2 = parseNaturalNumber(userInput);

                System.out.print("사칙연산 기호를 입력하세요: ");
                userInput = sc.nextLine();
                char operator = userInput.charAt(0);

                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);

            } catch(Exception e) {
                System.out.println("에러발생 : " + e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String lastAnswer = sc.nextLine();
            /* exit을 입력 받으면 반복 종료 */
            if (lastAnswer.trim().equals("exit")) {
                isContinue = false;
            }
        }
    }
}
