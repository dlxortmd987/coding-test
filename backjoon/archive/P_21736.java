package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P_21736 {

	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);

		int x = 0;
		int y = 0;
		int[][] g = new int[n][m];
		Map<Character, Integer> map = new HashMap<>();
		map.put('O', 0);
		map.put('X', -1);
		map.put('P', 1);
		map.put('I', 2);
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				if (line.charAt(j) == 'I') {
					x = j;
					y = i;
				}
				g[i][j] = map.get(line.charAt(j));
			}
		}

		int res = bfs(g, x, y);

		if (res == 0)
			System.out.println("TT");
		else
			System.out.println(res);

		br.close();
	}

	private static int bfs(int[][] g, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		boolean[][] v = new boolean[n][m];
		v[y][x] = true;
		int res = 0;

		int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];

				if (nx < 0 || nx >= m || ny < 0 || ny >= n)
					continue;

				if (g[ny][nx] >= 0 && !v[ny][nx]) {
					if (g[ny][nx] == 1)
						res++;
					v[ny][nx] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
		return res;
	}
}
