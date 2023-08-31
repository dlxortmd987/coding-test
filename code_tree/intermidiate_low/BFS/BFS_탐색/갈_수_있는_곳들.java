package code_tree.intermidiate_low.BFS.BFS_탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 갈_수_있는_곳들 {

	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static int bfs(int x, int y, int[][] g) {
		Queue<int[]> q = new LinkedList<>();
		v[y][x] = true;
		q.add(new int[] {x, y});
		int count = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= g[0].length || ny < 0 || ny >= g.length) {
					continue;
				}

				if (!v[ny][nx] && g[ny][nx] == 0) {
					count++;
					q.add(new int[] {nx, ny});
					v[ny][nx] = true;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] g = new int[n][n];
		v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		int answer = 0;
		for (int i = 0; i < k; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();

			if (v[y - 1][x - 1])
				continue;

			answer += bfs(x - 1, y - 1, g);
		}

		System.out.println(answer);
	}
}
