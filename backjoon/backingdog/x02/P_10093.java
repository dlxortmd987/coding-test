package backjoon.backingdog.x02;

import java.io.IOException;
import java.util.Scanner;

public class P_10093 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long temp1 = sc.nextLong();
        long temp2 = sc.nextLong();
        long a = Math.min(temp1, temp2);
        long b = Math.max(temp1, temp2);

        StringBuilder sb = new StringBuilder();
        for (long i = a + 1; i < b; i++) {
            sb.append(i).append(" ");
        }

        if (a > b) {
            return;
        }
        if (a == b) {
            System.out.println(0);
            return;
        }
        System.out.println(b - a - 1);
        System.out.println(sb);
    }
}
