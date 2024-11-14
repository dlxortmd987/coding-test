package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_2667 {

	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int[][] g = new int[n][n];
		boolean[][] v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String raw = br.readLine();
			for (int j = 0; j < raw.length(); j++) {
				g[i][j] = raw.charAt(j) - '0';
			}
		}

		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j] && g[i][j] == 1) {
					res.add(bfs(g, v, j, i));
				}
			}
		}

		System.out.println(res.size());
		Collections.sort(res);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

		br.close();
	}

	private static Integer bfs(int[][] g, boolean[][] v, int x, int y) {
		int count = 1;
		v[y][x] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (!v[ny][nx] && g[ny][nx] == 1) {
					count++;
					q.add(new int[] {nx, ny});
					v[ny][nx] = true;
				}
			}
		}
		return count;
	}
}
