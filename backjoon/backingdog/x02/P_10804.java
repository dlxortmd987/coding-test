package backjoon.backingdog.x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_10804 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[21];

        for (int i = 0; i < 21; i++) {
            arr[i] = i;
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String[] line = bf.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            int[] temp = new int[21];
            int p = b;
            for (int j = 1; j < 21; j++) {
                if (j < a || j > b) {
                    temp[j] = arr[j];
                } else {
                    temp[j] = arr[p];
                    p--;
                }
            }
            arr = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 21; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
