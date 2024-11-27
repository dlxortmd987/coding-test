package backjoon.backingdog.x02;

import java.io.IOException;
import java.util.Scanner;

public class P_2442 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < 2 * n; j++) {
                if (j < n - i) {
                    sb.append(" ");
                } else if (j <= n + i) {
                    sb.append("*");
                }
            }
            System.out.println(sb);
        }
    }
}
