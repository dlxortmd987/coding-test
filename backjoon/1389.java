package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main1389 {

    static int[][] g;
    static boolean[] visited;
    static int[] p;
    static int[] result;
    static int size;

    public static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            Integer a = q.poll();
            for (int b = 0; b < size; b++) {
                if (g[a][b] == 1 && !visited[b]) {
                    visited[b] = true;
                    q.add(b);

                    p[b] = p[a] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        size = n;
        g = new int[n][n];
        visited = new boolean[n];
        p = new int[n];
        result = new int[n];

        for (int i = 0; i < m; i++) {
            String[] raw = bf.readLine().split(" ");
            int a = Integer.parseInt(raw[0]) - 1;
            int b = Integer.parseInt(raw[1]) - 1;
            g[a][b] = 1;
            g[b][a] = 1;
        }

        for (int i = 0; i < size; i++) {
            bfs(i);

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                result[i] += p[j];
            }

            visited = new boolean[n];
            p = new int[n];
        }
        System.out.println(getMinPerson());
    }

    private static int getMinPerson() {
        int b = result[0];
        int person = 0;

        for (int i = 1; i < size; i++) {
            if (b > result[i]) {
                b = result[i];
                person = i;
            }
        }

        return person + 1;
    }
}
