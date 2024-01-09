package backjoon;

import java.io.IOException;
import java.util.Scanner;

public class P_10844 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long[][] dp = new long[101][10];

		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
			dp[2][i] = 2;
		}
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[2][9] = 1;

		for (int i = 3; i <= n; i++) {
			for (int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
			}
			dp[i][0] = dp[i - 1][1] % 1000000000;
			dp[i][9] = dp[i - 1][8] % 1000000000;
		}

		long res = 0;
		for (int i = 0; i < 10; i++) {
			res += dp[n][i];
		}

		System.out.println(res % 1000000000);
	}
}
