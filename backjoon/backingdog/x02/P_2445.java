package backjoon.backingdog.x02;

import java.io.IOException;
import java.util.Scanner;

public class P_2445 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (i <= n - 1) {
                    if (j <= i || (2 * n - 1 - i - 1) <= j) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                } else {
                    if (j <= 2 * n - i - 2 || i <= j) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            }
            if (i == 2 * n - 2) {
                continue;
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
