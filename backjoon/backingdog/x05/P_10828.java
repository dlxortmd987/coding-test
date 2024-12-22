package backjoon.backingdog.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");

            switch (line[0]) {
                case "push":
                    stack.addFirst(Integer.parseInt(line[1]));
                    break;
                case "pop":
                    Integer cur = stack.pollFirst();
                    if (cur != null) {
                        System.out.println(cur);
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                default:
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peekFirst());
                    }
                    break;
            }
        }
    }
}