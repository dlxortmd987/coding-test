package backjoon.backingdog.x02;

import java.io.IOException;
import java.util.Scanner;

public class P_2445 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < 2 * n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 2 * n; j++) {
                if (i <= n - 1) {
                    if (j <= i || (2 * n - i - 1) <= j) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                } else {
                    if (j <= 2 * n - i - 2 || i + 1 <= j) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
