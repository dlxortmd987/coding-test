package code_tree.intermidiate_low.Simulation.격자_안에서_밀고_당기기;

import java.util.Scanner;

public class 기울어진_직사각형의_회전 {

	static int[][] g;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		g = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		int m1 = sc.nextInt();
		int m2 = sc.nextInt();
		int m3 = sc.nextInt();
		int m4 = sc.nextInt();
		int dir = sc.nextInt();

		int t = g[r][c];
		if (dir == 0) {
			rotateAntiClock(r, c, m1, m2, m3, m4, t);
		} else {
			rotateClock(r, c, m1, m2, m3, m4, t);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(g[i][j]).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void rotateClock(int r, int c, int m1, int m2, int m3, int m4, int t) {
		// m1
		for (int i = 0; i < m1; i++) {
			g[r - i][c + i] = g[r - (i + 1)][c + (i + 1)];
		}

		// m2
		for (int i = 0; i < m2; i++) {
			int x = c + m1;
			int y = r - m1;
			g[y - i][x - i] = g[y - (i + 1)][x - (i + 1)];
		}

		// m3
		for (int i = 0; i < m3; i++) {
			int x = c + m1 - m2;
			int y = r - m1 - m2;
			g[y + i][x - i] = g[y + (i + 1)][x - (i + 1)];
		}

		// m4
		for (int i = 0; i < m4; i++) {
			int x = c - m4;
			int y = r - m4;
			g[y + i][x + i] = g[y + (i + 1)][x + (i + 1)];
		}

		g[r - 1][c - 1] = t;
	}

	private static void rotateAntiClock(int r, int c, int m1, int m2, int m3, int m4, int t) {
		// m4
		for (int i = 0; i < m4; i++) {
			g[r - i][c - i] = g[r - (i + 1)][c - (i + 1)];
		}

		// m3
		for (int i = 0; i < m3; i++) {
			int x = c - m4;
			int y = r - m4;
			g[y - i][x + i] = g[y - (i + 1)][x + (i + 1)];
		}

		// m2
		for (int i = 0; i < m2; i++) {
			int x = c - m4 + m3;
			int y = r - m4 - m3;
			g[y + i][x + i] = g[y + (i + 1)][x + (i + 1)];
		}

		// m1
		for (int i = 0; i < m1; i++) {
			int x = c + m1;
			int y = r - m1;
			g[y + i][x - i] = g[y + (i + 1)][x - (i + 1)];
		}

		g[r - 1][c + 1] = t;
	}
}
