package code_tree.intermidiate_low.BFS.가중치가_동일한_그래프에서의_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 비를_피하기 {

	static int[][] g;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y, 0});
		v[y][x] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (g[cur[1]][cur[0]] == 3) {
				return cur[2];
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= g[0].length || ny < 0 || ny >= g.length)
					continue;

				if (!v[ny][nx] && g[ny][nx] != 1) {
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
		int h = sc.nextInt();
		int m = sc.nextInt();
		g = new int[n][n];

		List<int[]> people = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
				if (g[i][j] == 2) {
					people.add(new int[] {j, i});
				}
			}
		}

		int[][] result = new int[n][n];

		for (int[] person : people) {
			v = new boolean[n][n];
			result[person[1]][person[0]] = bfs(person[0], person[1]);
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
