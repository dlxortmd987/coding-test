package backjoon.backingdog.x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class P_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nl = br.readLine().split(" ");
        int n = Integer.parseInt(nl[0]);
        int l = Integer.parseInt(nl[1]);

        String[] line = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Integer num = Integer.parseInt(line[i]);
            while (!deque.isEmpty() && deque.peekLast()[1] >= num) {
                deque.pollLast();
            }

            deque.add(new int[]{i, num});
            if (deque.peekFirst()[0] <= i - l) {
                deque.poll();
            }
            sb.append(deque.peekFirst()[1]).append(" ");
        }
        System.out.println(sb);
    }
}
