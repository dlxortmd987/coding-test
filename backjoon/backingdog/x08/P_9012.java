package backjoon.backingdog.x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Deque<Character> stack = new ArrayDeque<>();

            String line = br.readLine();
            boolean isVPS = true;
            for (char c : line.toCharArray()) {
                if (c == '(') {
                    stack.addFirst(c);
                } else {
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    } else {
                        stack.pollFirst();
                    }
                }
            }
            if (stack.isEmpty() && isVPS) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
