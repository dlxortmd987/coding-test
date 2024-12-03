package backjoon.backingdog.x02;

import java.io.IOException;
import java.util.Scanner;

public class P_2446 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < 2 * n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 2 * n - 1; j++) {
                if (i < n) {
                    if (j < i) {
                        sb.append(" ");
                    } else if (j < 2 * n - 1 - i) {
                        sb.append("*");
                    }
                } else {
                    if (j < 2 * n - 1 - i - 1) {
                        sb.append(" ");
                    } else if (j < i + 1) {
                        sb.append("*");
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
