package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (n == 1) {
			System.out.println(arr[0]);
			return;
		}

		int[] dp = new int[10001];
		dp[1] = arr[0];
		dp[2] = dp[1] + arr[1];

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i - 1], dp[i - 3] + arr[i - 2] + arr[i - 1]));
		}

		System.out.println(dp[n]);

		br.close();
	}
}
