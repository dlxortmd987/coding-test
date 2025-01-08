package backjoon.backingdog.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = br.readLine().split(" ");
            if (line.length == 1 && "0".equals(line[0])) {
                break;
            }

            int n = Integer.parseInt(line[0]);

            Stack<Long> s = new Stack<>();

            long max = 0L;
            for (int i = 1; i <= n; i++) {
                long cur = Integer.parseInt(line[i]);

                if (s.isEmpty()) {
                    s.push(cur);
                    max = Math.max(cur, max);
                    continue;
                }

                if (s.peek() > cur) {

                }
            }
            System.out.println(max);
        }
    }
}
