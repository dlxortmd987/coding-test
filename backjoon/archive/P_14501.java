package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			int t = Integer.parseInt(line[0]);
			int p = Integer.parseInt(line[1]);
			arr[i][0] = t;
			arr[i][1] = p;
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i][0] + i > n) {
				dp[i] = 0;
				continue;
			}

			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j][0] + j <= i) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + arr[i][1];
			res = Math.max(res, dp[i]);
		}

		System.out.println(res);

		br.close();
	}
}
