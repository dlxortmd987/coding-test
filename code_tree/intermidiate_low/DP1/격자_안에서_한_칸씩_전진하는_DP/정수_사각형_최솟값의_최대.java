package code_tree.intermidiate_low.DP1.격자_안에서_한_칸씩_전진하는_DP;

import java.util.Scanner;

public class 정수_사각형_최솟값의_최대 {
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

		dp[0][0] = g[0][0];

		for (int i = 1; i < n; i++) {
			dp[0][i] = Math.min(dp[0][i - 1], g[0][i]);
			dp[i][0] = Math.min(dp[i - 1][0], g[i][0]);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(Math.min(dp[i][j - 1], g[i][j]), Math.min(dp[i - 1][j], g[i][j]));
			}
		}

		System.out.println(dp[n - 1][n - 1]);
	}
}
