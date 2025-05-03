package level1;

import java.util.Scanner;

public class AppLv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* 반복문 사용 해서 연산을 반복 */
        boolean isContinue = true;
        while (isContinue) {
            String userInput;
            Scanner inputScanner;
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");

                if (!sc.hasNextInt()) {
                    sc.nextLine();
                    throw new RuntimeException("제대로 된 형식의 숫자를 입력해 주세요!");
                }
                userInput = sc.nextLine();
                inputScanner = new Scanner(userInput);
                int num1 = inputScanner.nextInt();

                if (num1 <= 0) throw new RuntimeException("양의 정수를 입력해 주세요!");

                System.out.print("두 번째 숫자를 입력하세요: ");
                if (!sc.hasNextInt()) {
                    sc.nextLine();
                    throw new RuntimeException("제대로 된 형식의 숫자를 입력해 주세요!");
                }
                userInput = sc.nextLine();
                inputScanner = new Scanner(userInput);
                int num2 = inputScanner.nextInt();
                if (num2 <= 0) throw new RuntimeException("양의 정수를 입력해 주세요!");

                System.out.print("사칙연산 기호를 입력하세요: ");
                userInput = sc.nextLine();
                char operator = userInput.charAt(0);

                int result = switch (operator) {
                    case '+' -> Math.addExact(num1, num2);
                    case '-' -> Math.subtractExact(num1, num2);
                    case '*' -> Math.multiplyExact(num1, num2);
                    case '/' -> Math.divideExact(num1, num2);
                    default -> throw new RuntimeException("지원하지 않는 연산자 입니다.");
                };

                System.out.println("결과: " + result);
            } catch(Exception e) {
                System.out.println("에러발생 : " + e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            userInput = sc.nextLine();
            /* exit을 입력 받으면 반복 종료 */
            if (userInput.equals("exit")) {
                isContinue = false;
                sc.close();
            }
        }
    }
}