package code_tree.intermidiate_low.DP1.격자_안에서_한_칸씩_전진하는_DP;

import java.util.Arrays;
import java.util.Scanner;

public class 정수_사각형_차이의_최소2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] g = new int[n][n];
		int[][][] dp = new int[n][n][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		dp[0][0][0] = g[0][0];
		dp[0][0][1] = g[0][0];

		for (int i = 1; i < n; i++) {
			dp[0][i][0] = Math.min(g[0][i], dp[0][i - 1][0]);
			dp[0][i][1] = Math.max(g[0][i], dp[0][i - 1][1]);

			dp[i][0][0] = Math.min(g[i][0], dp[i - 1][0][0]);
			dp[i][0][1] = Math.max(g[i][0], dp[i - 1][0][1]);
		}

		System.out.println("dp = " + Arrays.deepToString(dp));

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				int down = Math.abs(Math.max(g[i][j], dp[i - 1][j][1]) - Math.min(g[i][j], dp[i - 1][j][0]));
				System.out.println("down = " + down);
				int right = Math.abs(Math.max(g[i][j], dp[i][j - 1][1]) - Math.min(g[i][j], dp[i][j - 1][0]));

				System.out.println("right = " + right);

				if (down < right) {
					dp[i][j][0] = Math.min(g[i][j], dp[i - 1][j][0]);
					dp[i][j][1] = Math.max(g[i][j], dp[i - 1][j][1]);
				} else {
					dp[i][j][0] = Math.min(g[i][j], dp[i][j - 1][0]);
					dp[i][j][1] = Math.max(g[i][j], dp[i][j - 1][1]);
				}
				System.out.println(Arrays.toString(dp[i][j]));
			}
		}

		System.out.println(Math.abs(dp[n - 1][n - 1][0] - dp[n - 1][n - 1][1]));
	}
}
