package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] line = br.readLine().split(" ");
		int[] arr = new int[n];

		boolean isMinus = true;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line[i]);
			if (arr[i] > 0)
				isMinus = false;
		}

		if (n == 1) {
			System.out.println(arr[0]);
			return;
		}

		if (isMinus) {
			int res = -1000;
			for (int i = 0; i < n; i++) {
				res = Math.max(res, arr[i]);
			}
			System.out.println(res);
			return;
		}

		int[] dp = new int[n];
		dp[0] = arr[0];

		int res = arr[0];
		for (int i = 1; i < n; i++) {
			int k = dp[i - 1] + arr[i];
			if (k < 0) {
				dp[i] = 0;
			} else {
				dp[i] = k;
			}
			res = Math.max(dp[i], res);
		}

		System.out.println(res);

		br.close();
	}
}
