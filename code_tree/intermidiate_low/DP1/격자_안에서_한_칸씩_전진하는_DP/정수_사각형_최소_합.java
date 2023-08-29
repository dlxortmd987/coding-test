 package code_tree.intermidiate_low.DP1.격자_안에서_한_칸씩_전진하는_DP;

import java.util.Arrays;
import java.util.Scanner;

public class 정수_사각형_최소_합 {
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

		dp[0][n-1] = g[0][n-1];
		for (int i = 1; i < n; i++) {
			dp[0][n-i-1] = g[0][n-i-1] + dp[0][n-i];
			dp[i][n-1] = g[i][n-1] + dp[i-1][n-1];
		}

		for (int i = 1; i < n; i++) {
			for (int j = n-2; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i][j + 1] + g[i][j], dp[i - 1][j] + g[i][j]);
			}
		}

		System.out.println(dp[n-1][0]);
	}
}
