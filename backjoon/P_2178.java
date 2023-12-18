package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P_2178 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		int[][] g = new int[n][m];
		boolean[][] v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String raw = br.readLine();
			for (int j = 0; j < raw.length(); j++) {
				g[i][j] = raw.charAt(j) - '0';
			}
		}

		bfs(g, v);

		System.out.println(g[g.length - 1][g[0].length - 1]);

		br.close();
	}

	private static void bfs(int[][] g, boolean[][] v) {
		int count = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		v[0][0] = true;

		int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];

				if (nx < 0 || nx >= g[0].length || ny < 0 || ny >= g.length)
					continue;

				if (g[ny][nx] > 0 && !v[ny][nx]) {
					v[ny][nx] = true;
					g[ny][nx] = g[cur[1]][cur[0]] + 1;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
}
