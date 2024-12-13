package backjoon.backingdog.x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (!line.contains("<") && !line.contains(">") && !line.contains("-")) {
                result.append(line);
                continue;
            }

            int cursor = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                char cur = line.charAt(j);

                if (cur == '<') {
                    if (cursor == 0) {
                        continue;
                    }
                    cursor--;
                } else if (cur == '>') {
                    if (cursor == sb.length()) {
                        continue;
                    }
                    cursor++;
                } else if (cur == '-') {
                    if (cursor == 0) {
                        continue;
                    }
                    sb.deleteCharAt(cursor - 1);
                    cursor--;
                } else {
                    sb.insert(cursor, cur);
                    cursor++;
                }
            }
            sb.append('\n');
            result.append(sb);
        }
        System.out.println(result);
    }
}
