package backjoon.backingdog.x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int temp = k;
        while (!q.isEmpty()) {
            if (temp <= 1) {
                temp = k;
                result.add(q.poll());
                continue;
            }
            temp--;
            q.add(q.poll());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size() - 1; i++) {
            sb.append(result.get(i)).append(", ");
        }
        sb.append(result.get(result.size() - 1));
        sb.append(">");
        System.out.println(sb);
    }
}