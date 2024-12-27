package backjoon.backingdog.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<int[]> s = new Stack<>();
        int res = 0;

        for (int i = 1; i <= n; i++) {
            int cur = arr[i - 1];
            if (s.isEmpty()) {
                s.push(new int[]{cur, i});
                continue;
            }

            while (true) {
                if (s.isEmpty()) {
                    s.push(new int[]{cur, i});
                    break;
                }
                int[] temp = s.peek();

                if (temp[0] > cur) {
                    s.push(new int[]{cur, i});
                    break;
                }
                s.pop();
                res++;
            }
        }
        System.out.println(res);
    }
}
