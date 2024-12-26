package backjoon.backingdog.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
        }

        String[] tokens = br.readLine().split(" ");

        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(tokens[i - 1]);
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new int[]{cur, i});
                continue;
            }
            while (true) {
                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.push(new int[]{cur, i});
                    break;
                }

                int[] temp = stack.peek();

                if (temp[0] > cur) {
                    sb.append(temp[1]).append(" ");
                    stack.push(new int[]{cur, i});
                    break;
                }
                stack.pop();
            }
        }

        System.out.println(sb);
    }
}
