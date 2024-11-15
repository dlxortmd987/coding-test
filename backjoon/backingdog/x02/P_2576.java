package backjoon.backingdog.x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = 101;
        for (int i = 0; i < 7; i++) {
            int e = Integer.parseInt(bf.readLine());
            if (e % 2 == 1) {
                sum += e;
                min = Math.min(min, e);
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
