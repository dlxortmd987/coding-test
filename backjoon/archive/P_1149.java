package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(line[0]);
			arr[i][1] = Integer.parseInt(line[1]);
			arr[i][2] = Integer.parseInt(line[2]);
		}

		int[][] dp = new int[n][3];

		for (int i = 0; i < 3; i++) {
			dp[0][i] = arr[0][i];
		}

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
		}

		System.out.println(Math.min(dp[n - 1][2], Math.min(dp[n - 1][0], dp[n - 1][1])));

		br.close();
	}
}
