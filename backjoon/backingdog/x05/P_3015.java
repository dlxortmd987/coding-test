package backjoon.backingdog.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int res = n - 1;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }

            Integer top = stack.peek();

            if (top > cur) {
                stack.pop();
            } else {
                stack.push(cur);
                res++;
            }
        }
        System.out.println(res);
    }
}
