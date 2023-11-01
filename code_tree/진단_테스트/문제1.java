package code_tree.진단_테스트;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 문제1 {
	static int[][] g;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		g = new int[n][n];
		v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j] && g[i][j] == 1) {
					res = Math.max(res, bfs(n, j, i));
				}
			}
		}
		System.out.println(res);
	}

	private static int bfs(int n, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		v[y][x] = true;
		int count = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (!v[ny][nx] && g[ny][nx] == 1) {
					q.add(new int[] {nx, ny});
					v[ny][nx] = true;
					count++;
				}
			}
		}
		return count;
	}
}
