package code_tree.intermidiate_low.BFS.가중치가_동일한_그래프에서의_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 최소_경로로_탈출_하기 {

	static int[][] g;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 0});
		v[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == g[0].length - 1 && cur[1] == g.length - 1) {
				return cur[2];
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= g[0].length || ny < 0 || ny >= g.length)
					continue;

				if (!v[ny][nx] && g[ny][nx] == 1) {
					q.add(new int[] {nx, ny, cur[2] + 1});
					v[ny][nx] = true;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		g = new int[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		int answer = bfs();
		System.out.println(answer);
	}
}
