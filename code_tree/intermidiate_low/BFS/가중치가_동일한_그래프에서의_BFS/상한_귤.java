package code_tree.intermidiate_low.BFS.가중치가_동일한_그래프에서의_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 상한_귤 {

	static boolean[][] v;
	static int[][] g;
	static int[][] result;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	private static void bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		v[start[1]][start[0]] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int t = result[cur[1]][cur[0]];

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= g.length || ny < 0 || ny >= g.length)
					continue;

				if (!v[ny][nx] && g[ny][nx] == 1) {
					result[ny][nx] = result[ny][nx] != 0 ? Math.min(result[ny][nx], t + 1) : t + 1;
					q.add(new int[] {nx, ny});
					v[ny][nx] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		g = new int[n][n];
		result = new int[n][n];
		List<int[]> ret = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
				if (g[i][j] == 2) {
					ret.add(new int[] {j, i});
				}
			}
		}

		for (int[] tan : ret) {
			v = new boolean[n][n];
			bfs(tan);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (result[i][j] == 0 && g[i][j] == 1) {
					result[i][j] = -2;
				} else if (g[i][j] == 0) {
					result[i][j] = -1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}
