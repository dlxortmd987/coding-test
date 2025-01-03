package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		long[] dp = new long[101];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			for (int j = 6; j <= n; j++) {
				dp[j] = dp[j - 1] + dp[j - 5];
			}
			System.out.println(dp[n]);
		}

		br.close();
	}
}
