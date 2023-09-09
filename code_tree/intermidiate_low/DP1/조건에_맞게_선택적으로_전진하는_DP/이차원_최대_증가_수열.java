package code_tree.intermidiate_low.DP1.조건에_맞게_선택적으로_전진하는_DP;

import java.util.Scanner;

public class 이차원_최대_증가_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] g = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		int[][] dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}

		dp[0][0] = 1;
		int answer = dp[0][0];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				for (int k = 0; k < i; k++) {
					for (int l = 0; l < j; l++) {
						if (g[i][j] > g[k][l]) {
							dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
						}
					}
				}
				answer = Math.max(answer, dp[i][j]);
			}
		}

		System.out.println(answer);
	}
}
