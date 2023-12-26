package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P_7569 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] mnh = br.readLine().split(" ");
		int m = Integer.parseInt(mnh[0]);
		int n = Integer.parseInt(mnh[1]);
		int h = Integer.parseInt(mnh[2]);

		int[][][] g = new int[h][n][m];

		Queue<int[]> already = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				String[] line = br.readLine().split(" ");
				for (int k = 0; k < line.length; k++) {
					g[i][j][k] = Integer.parseInt(line[k]);
					if (g[i][j][k] == 1) {
						already.add(new int[] {k, j, i});
					}
				}
			}
		}

		System.out.println(bfs(g, already));

		br.close();
	}

	private static int bfs(int[][][] g, Queue<int[]> already) {
		int[][] d = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
		while (!already.isEmpty()) {
			int[] t = already.poll();
			int x = t[0];
			int y = t[1];
			int h = t[2];

			for (int i = 0; i < 6; i++) {
				int nx = x + d[i][0];
				int ny = y + d[i][1];
				int nh = h + d[i][2];

				if (nx < 0 || nx >= g[0][0].length || ny < 0 || ny >= g[0].length || nh < 0 || nh >= g.length) {
					continue;
				}

				if (g[nh][ny][nx] == 0) {
					already.add(new int[] {nx, ny, nh});
					g[nh][ny][nx] = g[h][y][x] + 1;
				}
			}
		}

		int res = Integer.MIN_VALUE;
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[0].length; j++) {
				for (int k = 0; k < g[0][0].length; k++) {
					if (g[i][j][k] == 0)
						return -1;
					res = Math.max(res, g[i][j][k]);
				}
			}
		}
		if (res == 1)
			return 0;
		return res - 1;
	}
}
