package backjoon.backingdog.x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String[] line = bf.readLine().split(" ");
            sb.append(Integer.parseInt(line[0]) + Integer.parseInt(line[1])).append("\n");
        }
        System.out.println(sb);
    }
}
