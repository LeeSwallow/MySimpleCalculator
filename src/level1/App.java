package level1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* 반복문 사용 해서 연산을 반복 */
        boolean isContinue = true;
        while (isContinue) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요:");
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요:");
                int num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                int result = switch (operator) {
                    case '+' -> num1 + num2;
                    case '-' -> num1 - num2;
                    case '*' -> num1 * num2;
                    case '/' -> num1 / num2;
                    default -> throw new RuntimeException("지원하지 않는 연산자 입니다.");
                };
                System.out.println("결과: " + result);
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String lastAnswer = sc.next();
                /* exit을 입력 받으면 반복 종료 */
                if (lastAnswer.equals("exit")) {
                    isContinue = false;
                }
            } catch(Exception e) {
                System.out.println("에러발생 : " + e.getMessage());
            }
        }


    }
}