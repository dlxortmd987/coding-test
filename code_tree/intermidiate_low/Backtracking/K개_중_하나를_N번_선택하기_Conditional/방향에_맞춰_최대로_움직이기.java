package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Conditional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 방향에_맞춰_최대로_움직이기 {

	static int n;
	static int answer;

	static int[][] g;
	static int[][] dir;

	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

	static List<Integer> arr = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		g = new int[n][n];
		dir = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dir[i][j] = sc.nextInt() - 1;
			}
		}

		int r = sc.nextInt();
		int c = sc.nextInt();

		func(c - 1, r - 1, 0);

		System.out.println(answer);
	}

	private static void func(int x, int y, int cnt) {
		if (!possible(x, y)) {
			answer = Math.max(answer, cnt);
			return;
		}

		int nx = x;
		int ny = y;
		for (int i = 1; i < n; i++) {
			nx += dx[dir[y][x]];
			ny += dy[dir[y][x]];

			if (isOutRange(nx, ny))
				break;

			if (g[y][x] >= g[ny][nx])
				continue;

			func(nx, ny, cnt + 1);
		}
	}

	private static boolean possible(int x, int y) {
		int cur = g[y][x];
		int[] d = {dx[dir[y][x]], dy[dir[y][x]]};

		for (int i = 1; i < n; i++) {
			int nx = x + d[0] * i;
			int ny = y + d[1] * i;

			if (isOutRange(nx, ny))
				break;

			if (cur >= g[ny][nx])
				continue;

			return true;
		}

		return false;
	}

	private static boolean isOutRange(int nx, int ny) {
		return nx < 0 || nx >= n || ny < 0 || ny >= n;
	}
}
