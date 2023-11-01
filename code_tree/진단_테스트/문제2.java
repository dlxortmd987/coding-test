package code_tree.진단_테스트;

import java.util.Scanner;

public class 문제2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] g = new int[n][n];
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			dp[0][i] = g[0][i];
		}

		int[] dx = {-1, 0, 1};
		int[] dy = {-1, -1, -1};

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cur = g[i][j];
				for (int k = 0; k < 3; k++) {
					int nx = j + dx[k];
					int ny = i + dy[k];

					if (nx < 0 || nx >= n)
						continue;

					dp[i][j] = Math.max(dp[i][j], cur + dp[ny][nx]);
				}
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res = Math.max(dp[i][j], res);
			}
		}
		System.out.println(res);
	}
}
