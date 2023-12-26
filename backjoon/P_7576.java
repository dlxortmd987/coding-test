package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P_7576 {

	static int m;
	static int n;
	static int[][] g;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] mn = br.readLine().split(" ");
		m = Integer.parseInt(mn[0]);
		n = Integer.parseInt(mn[1]);

		g = new int[n][m];
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				g[i][j] = Integer.parseInt(line[j]);
				if (g[i][j] == 1)
					q.add(new int[] {j, i});
			}
		}

		System.out.println(bfs(q));

		br.close();
	}

	private static int bfs(Queue<int[]> q) {
		int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = d[i][0] + cur[0];
				int ny = d[i][1] + cur[1];

				if (nx < 0 || nx >= m || ny < 0 || ny >= n)
					continue;

				if (g[ny][nx] == 0) {
					q.add(new int[] {nx, ny});
					g[ny][nx] = g[cur[1]][cur[0]] + 1;
				}
			}
		}

		int res = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (g[i][j] == 0)
					return -1;
				res = Math.max(res, g[i][j]);
			}
		}
		return res - 1;
	}
}
