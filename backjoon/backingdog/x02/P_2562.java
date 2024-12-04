package backjoon.backingdog.x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;
        int max = -1;

        for (int i = 0; i < 9; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (cur > max) {
                n = i + 1;
                max = cur;
            }
        }

        System.out.println(max);
        System.out.println(n);
    }
}
