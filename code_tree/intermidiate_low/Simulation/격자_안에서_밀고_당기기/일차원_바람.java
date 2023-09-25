package code_tree.intermidiate_low.Simulation.격자_안에서_밀고_당기기;

import java.util.Scanner;

public class 일차원_바람 {

	static int n;
	static int m;
	static int[][] g;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		g = new int[n][m];

		int q = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		int[] lines = new int[q];
		boolean[] dirs = new boolean[q];
		for (int i = 0; i < q; i++) {
			lines[i] = sc.nextInt();
			String d = sc.next();
			if (d.equals("L")) {
				dirs[i] = true;
			} else {
				dirs[i] = false;
			}
		}

		for (int i = 0; i < q; i++) {
			int line = lines[i] - 1;
			boolean d = dirs[i];

			shift(line, d);

			boolean rd = d;
			for (int j = 1; line - j >= 0; j++) {
				rd = !rd;
				if (containSame(line - (j - 1), line - j)) {
					shift(line - j, rd);
				} else {
					break;
				}
			}
			rd = d;
			for (int j = 1; line + j < n; j++) {
				rd = !rd;
				if (containSame(line + (j - 1), line + j)) {
					shift(line + j, rd);
				} else {
					break;
				}
			}
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

	private static boolean containSame(int line, int compare) {
		for (int i = 0; i < m; i++) {
			if (g[line][i] == g[compare][i]) {
				return true;
			}
		}
		return false;
	}

	private static void shift(int line, boolean d) {
		int t;

		if (d) {
			t = g[line][m - 1];
			for (int i = m - 1; i > 0; i--) {
				g[line][i] = g[line][i - 1];
			}
			g[line][0] = t;
		} else {
			t = g[line][0];
			for (int i = 0; i < m - 1; i++) {
				g[line][i] = g[line][i + 1];
			}
			g[line][m - 1] = t;
		}
	}
}
