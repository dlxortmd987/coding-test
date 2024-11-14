package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[][] dp = new int[n + 1][2];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (n < 2) {
			System.out.println(arr[0]);
			return;
		} else if (n < 3) {
			System.out.println(arr[0] + arr[1]);
			return;
		}

		dp[0][0] = 0;
		dp[1][0] = arr[0];
		dp[1][1] = arr[0];
		dp[2][0] = arr[1] + dp[1][0];
		dp[2][1] = arr[1];

		for (int i = 3; i < n + 1; i++) {
			dp[i][0] = dp[i - 1][1] + arr[i - 1];
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i - 1];
		}

		System.out.println(Math.max(dp[n][0], dp[n][1]));

		br.close();
	}
}
