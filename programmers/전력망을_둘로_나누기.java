package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class 전력망을_둘로_나누기 {

    int size;
    int[][] g;


    public int bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        boolean[] v = new boolean[size];
        int count = 1;

        while (!q.isEmpty()) {
            Integer a = q.poll();
            v[a] = true;
            for (int b = 0; b < size; b++) {
                if (a != b && g[a][b] == 1 && !v[b]) {
                    q.add(b);
                    count++;
                }
            }
        }
        return Math.abs(size - 2 * count);
    }

    public int solution(int n, int[][] wires) {
        int answer = n;

        size = n;
        g = new int[n][n];

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (i == j) continue;
                g[wires[j][0]-1][wires[j][1]-1] = 1;
                g[wires[j][1]-1][wires[j][0]-1] = 1;
            }

            for (int k = 0; k < size; k++) {
                answer = Math.min(answer, bfs(k));
            }

            g = new int[n][n];
        }

        return answer;
    }
}