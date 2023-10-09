package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 강력한_폭발 {

	static int n;
	static int[][] g;

	static int[][][] d = {
		{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}},
		{{0, 0}, {0, 1}, {0, 2}, {0, -1}, {0, -2}},
		{{0, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}}
	};

	static int answer = 0;

	static List<int[]> starts = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		g = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
				if (g[i][j] == 1) {
					starts.add(new int[] {j, i});
				}
			}
		}

		func(0);

		System.out.println(answer);
	}

	private static void func(int i) {
		if (i == starts.size()) {
			int cur = count();
			answer = Math.max(answer, cur);
			return;
		}

		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 5; k++) {
				int nx = starts.get(i)[0] + d[j][k][0];
				int ny = starts.get(i)[1] + d[j][k][1];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				g[ny][nx] += 1;
			}

			func(i + 1);

			for (int k = 0; k < 5; k++) {
				int nx = starts.get(i)[0] + d[j][k][0];
				int ny = starts.get(i)[1] + d[j][k][1];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				g[ny][nx] -= 1;
			}
		}
	}

	private static int count() {
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] >= 1) {
					cnt++;
				}
			}
		}

		return cnt;
	}

}
