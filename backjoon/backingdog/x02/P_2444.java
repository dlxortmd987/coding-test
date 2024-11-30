package backjoon.backingdog.x02;

import java.io.IOException;
import java.util.Scanner;

public class P_2444 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = 0; i < 2 * n - 1; i++) {
            sb.append("*");
        }
        sb.append("\n");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < 2 * (n - i - 2) + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
