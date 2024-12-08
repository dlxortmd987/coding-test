package backjoon.backingdog.x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        int result = 0;
        for (int i = 0; i < line.length; i++) {
            int e = Integer.parseInt(line[i]);
            if (set.contains(x - e)) {
                result++;
            }
            set.add(e);
        }

        System.out.println(result);
    }
}