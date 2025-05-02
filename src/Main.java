
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("테스트 할 level을 입력하세요(1~3) : ");
        int n = sc.nextInt();
        String[] noArgs = new String[0];
        switch (n) {
            case 1:
                level1.App.main(noArgs);
                break;
            case 2:
                level2.App.main(noArgs);
                break;
            case 3:
                level3.App.main(noArgs);
                break;
        }
        sc.close();
    }
}