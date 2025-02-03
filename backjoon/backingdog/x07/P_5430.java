package backjoon.backingdog.x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class P_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            Deque<Integer> arr = new LinkedList<>();

            if (line.length() > 2) {
                String[] raw = line.substring(1, line.length() - 1).split(",");
                for (int j = 0; j < raw.length; j++) {
                    arr.add(Integer.parseInt(raw[j]));
                }
            }
            boolean isFront = true;
            boolean isError = false;
            for (char c : p) {
                if (c == 'R') {
                    isFront = !isFront;
                } else {
                    if (arr.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if (isFront) {
                        arr.pollFirst();
                    } else {
                        arr.pollLast();
                    }
                }
            }
            if (isError) {
                continue;
            }
            if (arr.isEmpty()) {
                sb.append("[]\n");
                continue;
            }
            sb.append("[");
            int size = arr.size();
            if (isFront) {
                for (int j = 0; j < size - 1; j++) {
                    sb.append(arr.pollFirst()).append(",");
                }
            } else {
                for (int j = size - 1; j > 0; j--) {
                    sb.append(arr.pollLast()).append(",");
                }
            }
            sb.append(arr.poll()).append("]\n");
        }
        System.out.println(sb);
    }
}
