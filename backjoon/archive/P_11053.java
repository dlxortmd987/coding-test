package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] line = br.readLine().split(" ");
		int[] dp = new int[1001];
		Arrays.fill(dp, 1);
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(line[i - 1]);
		}

		int res = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (dp[j] + 1 > dp[i] && arr[j] < arr[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			res = Math.max(res, dp[i]);
		}

		System.out.println(res);
		br.close();
	}
}
