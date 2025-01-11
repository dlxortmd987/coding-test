package backjoon.backingdog.x06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P_18258 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        int back = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            switch (line[0]) {
                case "push":
                    q.add(Integer.parseInt(line[1]));
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.get(0)).append("\n");
                        q.remove(0);
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.get(0)).append("\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.get(q.size() - 1)).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
