package code_tree.intermidiate_low.Simulation.격자_안에서_밀고_당기기;

import java.util.Scanner;

public class 이차원_바람 {

	static int n;
	static int m;
	static int[][] g;
	static int[][] result;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		g = new int[n][m];
		result = new int[n][m];

		int q = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
				result[i][j] = g[i][j];
			}
		}

		int[][] qs = new int[q][4];
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < 4; j++) {
				qs[i][j] = sc.nextInt();

			}
		}

		for (int i = 0; i < q; i++) {
			int r1 = qs[i][0] - 1;
			int c1 = qs[i][1] - 1;
			int r2 = qs[i][2] - 1;
			int c2 = qs[i][3] - 1;

			shift(r1, c1, r2, c2);

			calc(r1, c1, r2, c2);

			copy();
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(g[i][j]).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void copy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = result[i][j];
			}
		}
	}

	private static void calc(int r1, int c1, int r2, int c2) {
		for (int j = r1; j <= r2; j++) {
			for (int k = c1; k <= c2; k++) {
				int sum = g[j][k];
				int count = 1;
				for (int l = 0; l < 4; l++) {
					int nx = k + dx[l];
					int ny = j + dy[l];

					if (nx < 0 || nx >= m || ny < 0 || ny >= n)
						continue;

					sum += g[ny][nx];
					count++;
				}
				result[j][k] = sum / count;
			}
		}
	}

	private static void shift(int uy, int lx, int dy, int rx) {
		int t = g[uy][lx];

		// 아래 -> 위
		for (int j = uy; j < dy; j++) {
			g[j][lx] = g[j + 1][lx];
		}

		// 오른쪽 -> 왼쪽
		for (int j = lx; j < rx; j++) {
			g[dy][j] = g[dy][j + 1];
		}

		// 위 -> 아래
		for (int j = dy; j > uy; j--) {
			g[j][rx] = g[j - 1][rx];
		}

		// 왼쪽 -> 오른쪽
		for (int j = rx; j > lx; j--) {
			g[uy][j] = g[uy][j - 1];
		}

		g[uy][lx + 1] = t;
	}

}
