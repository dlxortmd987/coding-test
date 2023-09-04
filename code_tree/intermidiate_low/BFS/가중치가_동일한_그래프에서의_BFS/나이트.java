package code_tree.intermidiate_low.BFS.가중치가_동일한_그래프에서의_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트 {

	static boolean[][] v;
	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

	private static int bfs(int n, int y1, int x1, int y2, int x2) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x1, y1, 0});
		v[y1][x1] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == x2 && cur[1] == y2) {
				return cur[2];
			}

			for (int i = 0; i < 8; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (!v[ny][nx]) {
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
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		v = new boolean[n][n];

		int answer = bfs(n, r1 - 1, c1 - 1, r2 - 1, c2 - 1);
		System.out.println(answer);
	}
}
