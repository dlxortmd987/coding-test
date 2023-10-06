package code_tree.intermidiate_low.Simulation.격자_안에서_완전_탐색;

import java.util.Scanner;

public class 격자_안에서_완전탐색 {

	static int[] dx = {1, -1, -1, 1};
	static int[] dy = {-1, -1, 1, 1};
	static int max = 0;

	public static void func(int x, int y, int[][] g, int idx, int cur, int firstX, int firstY) {
		if (idx == 4) {
			if (x != firstX || y != firstY) return;
			max = Math.max(max, cur);
			return;
		}

		int nx = x + dx[idx];
		int ny = y + dy[idx];

		if (nx < 0 || nx >= g.length || ny < 0 || ny >= g.length)
			return;

		func(nx, ny, g, idx, cur + g[ny][nx], firstX, firstY);
		func(nx, ny, g, idx + 1, cur + g[ny][nx], firstX, firstY);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] g = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				func(j, i, g, 0, 0, j, i);
			}
		}
		System.out.println(max);
	}

}
