package backjoon.backingdog.x02;

import java.io.IOException;
import java.util.Scanner;

public class P_2438 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i + 1; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }
}
