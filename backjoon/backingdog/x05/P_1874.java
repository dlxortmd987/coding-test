package backjoon.backingdog.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class P_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int cur = 1;
        List<String> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(br.readLine());
            for (int j = cur; j <= k; j++) {
                stack.push(j);
                arr.add("+");
            }
            if (!stack.isEmpty() && stack.peek() == k) {
                arr.add("-");
                stack.pop();
                cur = Math.max(cur, k + 1);
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(arr.stream()
                .collect(Collectors.joining("\n")));
    }
}
