package backjoon.backingdog.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long res = 0L;

        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            long cur = Long.parseLong(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }
            res += stack.size();
            stack.push(cur);
        }
        System.out.println(res);
    }
}
