
import level1.AppLv1;
import level2.AppLv2;
import level3.AppLv3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("테스트 할 level을 입력하세요(1~3) : ");
        int n = sc.nextInt();
        String[] noArgs = new String[0];
        switch (n) {
            case 1:
                AppLv1.main(noArgs);
                break;
            case 2:
                AppLv2.main(noArgs);
                break;
            case 3:
                AppLv3.main(noArgs);
                break;
        }
        sc.close();
    }
}