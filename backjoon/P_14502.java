package backjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P_14502 {

	static int[][] g;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		g = new int[n][m];

		List<int[]> empty = new ArrayList<>();
		List<int[]> virus = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
				if (g[i][j] == 0) {
					empty.add(new int[] {j, i});
				} else if (g[i][j] == 2) {
					virus.add(new int[] {j, i});
				}
			}
		}

		int res = 0;
		for (int i = 0; i < empty.size(); i++) {
			g[empty.get(i)[1]][empty.get(i)[0]] = 1;
			for (int j = i + 1; j < empty.size(); j++) {
				g[empty.get(j)[1]][empty.get(j)[0]] = 1;
				for (int k = j + 1; k < empty.size(); k++) {
					g[empty.get(k)[1]][empty.get(k)[0]] = 1;
					int count = bfs(virus);
					res = Math.max(res, empty.size() - 3 - count);
					g[empty.get(k)[1]][empty.get(k)[0]] = 0;
				}
				g[empty.get(j)[1]][empty.get(j)[0]] = 0;
			}
			g[empty.get(i)[1]][empty.get(i)[0]] = 0;
		}

		System.out.println(res);

	}

	private static int bfs(List<int[]> virus) {
		int n = g.length;
		int m = g[0].length;
		int res = 0;
		boolean[][] v = new boolean[n][m];

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			q.add(virus.get(i));
			v[virus.get(i)[1]][virus.get(i)[0]] = true;
		}
		int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = d[i][0] + cur[0];
				int ny = d[i][1] + cur[1];

				if (nx < 0 || nx >= m || ny < 0 || ny >= n)
					continue;

				if (!v[ny][nx] && g[ny][nx] == 0) {
					v[ny][nx] = true;
					res++;
					q.add(new int[] {nx, ny});
				}
			}
		}

		return res;
	}
}
