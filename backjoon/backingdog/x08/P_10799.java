package backjoon.backingdog.x08;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String raw = sc.nextLine();

        String str = raw.replace("()", "x");

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.addFirst(0);
            } else if (c == 'x' && !stack.isEmpty()) {
                Integer cur = stack.pollFirst();
                stack.addFirst(cur + 1);
            } else if (c == ')') {
                Integer ret = stack.pollFirst();
                res += ret + 1;

                if (stack.isEmpty()) {
                    continue;
                }
                stack.addFirst(ret + stack.pollFirst());
            }
        }
        System.out.println(res);
    }
}
