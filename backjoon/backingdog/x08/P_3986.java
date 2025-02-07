package backjoon.backingdog.x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int res = 0;
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();

            Deque<Character> dq = new LinkedList<Character>();
            boolean isGood = true;
            for (char c : line) {
                if (dq.isEmpty()) {
                    dq.addFirst(c);
                } else if (dq.peekFirst() == c) {
                    dq.pollFirst();
                } else if (dq.peekFirst() != c) {
                    dq.addFirst(c);
                }
            }
            if (dq.isEmpty()) {
                res++;
            }
        }
        System.out.println(res);
    }
}
