package code_tree.intermidiate_low.Backtracking.격자_안에서_완전_탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 금_채굴하기 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] g = new int[n][n];
		int coinCount = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
				if(g[i][j] == 1)
					coinCount++;
			}
		}

		int k = 0;

		while ((k + 2)*(k + 2) + (k + 1)* (k + 1) <= m * coinCount) {
			k++;
		}

		k = Math.min(k, n);
		int result = 0;

		while (k >= 0){
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int t = func(j, i, k, g);
					if (result < t && k*k + (k + 1)*(k + 1) <= t*m) result = t;
				}
			}
			k--;
		}

		System.out.println(result);
	}

	private static int func(int x, int y, int k, int[][] g) {
		Queue<int[]> q = new LinkedList<>();
		int result = 0;
		if (g[y][x] == 1) result++;
		q.add(new int[] {x, y, 0});
		boolean[][] v = new boolean[g.length][g.length];
		v[y][x] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[2] == k) {
				continue;
			}


			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= g.length || ny < 0 || ny >= g.length) continue;

				if (!v[ny][nx]) {
					v[ny][nx] = true;
					if (g[ny][nx] == 1)
						result++;
					q.add(new int[] {nx, ny, cur[2] + 1});
				}
			}
		}

		return result;
	}
}
