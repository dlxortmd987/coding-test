package backjoon.backingdog.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(line[i]);
            while (true) {
                if (stack.isEmpty()) {
                    break;
                }
                int[] temp = stack.peek();
                if (temp[0] < cur) {
                    stack.pop();
                    res[temp[1]] = cur;
                } else {
                    break;
                }
            }
            stack.push(new int[]{cur, i});
        }
        while (!stack.isEmpty()) {
            res[stack.pop()[1]] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }
}
