package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_20057 {

	static int n;

	static int[][] g;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	static int[][][] blow = {
		{
			{0, -1, 7}, {0, 1, 7},
			{-1, -1, 10}, {-1, 1, 10},
			{1, -1, 1}, {1, 1, 1},
			{0, -2, 2}, {0, 2, 2},
			{-2, 0, 5}, {-1, 0, -1}
		},
		{
			{1, 0, 7}, {-1, 0, 7},
			{1, -1, 1}, {-1, -1, 1},
			{1, 1, 10}, {-1, 1, 10},
			{2, 0, 2}, {-2, 0, 2},
			{0, 2, 5}, {0, 1, -1}
		},
		{
			{0, -1, 7}, {0, 1, 7},
			{-1, -1, 1}, {-1, 1, 1},
			{1, -1, 10}, {1, 1, 10},
			{0, -2, 2}, {0, 2, 2},
			{2, 0, 5}, {1, 0, -1}
		},
		{
			{1, 0, 7}, {-1, 0, 7},
			{1, 1, 1}, {-1, 1, 1},
			{1, -1, 10}, {-1, -1, 10},
			{2, 0, 2}, {-2, 0, 2},
			{0, -2, 5}, {0, -1, -1}
		}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		g = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				g[i][j] = Integer.parseInt(line[j]);
			}
		}

		int res = move();

		System.out.println(res);

		br.close();
	}

	private static int move() {
		int r = 1;
		int curX = n / 2;
		int curY = n / 2;
		int res = 0;

		int curD = 0;
		int rt = 1;
		while (true) {
			int nx = curX;
			int ny = curY;
			for (int i = 0; i < r; i++) {
				nx += d[curD][0];
				ny += d[curD][1];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					return res;

				int remain = g[ny][nx];
				int sum = 0;
				for (int j = 0; j < 9; j++) {
					int tx = nx + blow[curD][j][0];
					int ty = ny + blow[curD][j][1];
					int k = (remain * blow[curD][j][2]) / 100;
					sum += k;

					if (tx < 0 || tx >= n || ty < 0 || ty >= n)
						res += k;
					else
						g[ty][tx] += k;

				}

				int ax = nx + blow[curD][9][0];
				int ay = ny + blow[curD][9][1];
				int ak = remain - sum;
				if (ax < 0 || ax >= n || ay < 0 || ay >= n)
					res += ak;
				else
					g[ay][ax] += ak;
				g[ny][nx] = 0;
			}

			curD = curD == 3 ? 0 : curD + 1;
			curX = nx;
			curY = ny;
			if (rt == 0) {
				rt = 1;
				r += 1;
			} else {
				rt--;
			}
		}
	}
}
