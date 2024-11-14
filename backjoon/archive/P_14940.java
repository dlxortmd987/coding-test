package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P_14940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		int[][] g = new int[n][m];
		int[][] res = new int[n][m];
		boolean[][] v = new boolean[n][m];

		int sx = 0;
		int sy = 0;
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				g[i][j] = Integer.parseInt(line[j]);
				if (g[i][j] == 2) {
					sx = j;
					sy = i;
				}
			}
		}

		bfs(sx, sy, g, v, res);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (g[i][j] == 1 && !v[i][j])
					sb.append(-1).append(' ');
				else
					sb.append(res[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);

		br.close();
	}

	private static void bfs(int sx, int sy, int[][] g, boolean[][] v, int[][] res) {
		int n = g.length;
		int m = g[0].length;
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] {sx, sy});

		v[sy][sx] = true;
		int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = d[i][0] + cur[0];
				int ny = d[i][1] + cur[1];

				if (nx < 0 || nx >= m || ny < 0 || ny >= n)
					continue;

				if (!v[ny][nx] && g[ny][nx] != 0) {
					q.add(new int[] {nx, ny});
					v[ny][nx] = true;
					res[ny][nx] = res[cur[1]][cur[0]] + 1;
				}
			}
		}
	}
}
