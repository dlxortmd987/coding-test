package backjoon.archive;

import java.io.IOException;
import java.util.Scanner;

public class P_1010 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		int[][] dp = new int[30][30];

		for (int i = 0; i < 30; i++) {
			dp[0][i] = 1;
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		dp[0][0] = 0;

		for (int n = 1; n < 30; n++) {
			for (int r = 1; r <= n; r++) {
				dp[n][r] = dp[n - 1][r - 1] + dp[n - 1][r];
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			sb.append(dp[m][n]).append('\n');
		}

		System.out.println(sb);
	}
}
