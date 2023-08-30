package code_tree.intermidiate_low.BFS.BFS_탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 네_방향_탈출_가능_여부_판별하기 {

	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static int bfs(int x, int y, int[][] g) {
		Queue<int[]> q = new LinkedList<>();
		v[y][x] = true;
		q.add(new int[] {x, y});

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == g[0].length - 1 && cur[1] == g.length - 1) {
				return 1;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= g[0].length || ny < 0 || ny >= g.length) {
					continue;
				}

				if (!v[ny][nx] && g[ny][nx] == 1) {
					q.add(new int[] {nx, ny});
					v[ny][nx] = true;
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] g = new int[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		System.out.println(bfs(0, 0, g));
	}
}
