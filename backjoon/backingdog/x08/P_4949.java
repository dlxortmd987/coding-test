package backjoon.backingdog.x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (".".equals(line)) {
                break;
            }

            Stack<Character> s = new Stack<>();
            boolean isBalance = true;
            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[') {
                    s.push(c);
                } else if (c == ')') {
                    if (s.isEmpty() || s.peek() != '(') {
                        isBalance = false;
                        break;
                    } else {
                        s.pop();
                    }
                } else if (c == ']') {
                    if (s.isEmpty() || s.peek() != '[') {
                        isBalance = false;
                        break;
                    } else {
                        s.pop();
                    }
                }
            }
            if (!s.isEmpty()) {
                isBalance = false;
            }

            if (isBalance) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
