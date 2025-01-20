package backjoon.backingdog.x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class P_10866 {
    public static void main(String[] args) throws IOException {
        List<Integer> deque = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");

            switch (line[0]) {
                case "push_front":
                    deque.add(0, Integer.parseInt(line[1]));
                    break;
                case "push_back":
                    deque.add(Integer.parseInt(line[1]));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.get(0)).append("\n");
                        deque.remove(0);
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.get(deque.size() - 1)).append("\n");
                        deque.remove(deque.size() - 1);
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.get(0)).append("\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.get(deque.size() - 1)).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
