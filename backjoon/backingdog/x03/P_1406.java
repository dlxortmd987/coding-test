package backjoon.backingdog.x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String init = br.readLine();
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(init);

        int cursor = sb.length();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            if (line.charAt(0) == 'L') {
                if (cursor == 0) {
                    continue;
                }
                cursor--;
            } else if (line.charAt(0) == 'D') {
                if (cursor == sb.length()) {
                    continue;
                }
                cursor++;
            } else if (line.charAt(0) == 'B') {
                if (cursor == 0) {
                    continue;
                }
                sb.deleteCharAt(cursor - 1);
                cursor--;
            } else {
                char a = line.charAt(2);
                sb.insert(cursor, a);
                cursor++;
            }
        }
        System.out.println(sb);
    }
}