package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2630 {

	static int[][] d = {{0, 0}, {1, 0}, {0, 1}, {1, 1}};
	static int w = 0;
	static int b = 0;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		N = n;

		int[][] g = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] raw = br.readLine().split(" ");
			for (int j = 0; j < raw.length; j++) {
				g[i][j] = Integer.parseInt(raw[j]);
			}
		}

		func(g, n, 0, 0);
		System.out.println(w);
		System.out.println(b);

		br.close();
	}

	private static int func(int[][] g, int n, int x, int y) {
		if (n == 1) {
			if (g[y][x] == 1) {
				return 1;
			} else {
				return -1;
			}
		}
		int next = n / 2;
		int[] fill = new int[4];
		int blue = 0;
		int white = 0;
		for (int i = 0; i < 4; i++) {
			fill[i] = func(g, next, x + next * d[i][0], y + next * d[i][1]);
			if (fill[i] == 1) {
				blue++;
			} else if (fill[i] == -1) {
				white++;
			}
		}

		if (blue == 4) {
			if (n == N) {
				b = 1;
				w = 0;
			}
			return 1;
		} else if (white == 4) {
			if (n == N) {
				b = 0;
				w = 1;
			}
			return -1;
		}

		b += blue;
		w += white;
		return 0;
	}
}
