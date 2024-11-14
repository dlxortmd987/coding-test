package backjoon.archive;

import java.util.Arrays;
import java.util.Scanner;

public class P_1697 {

	private static final int MAX_VALUE = 100000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = 5;
		int k = 17;

		if (n >= k) {
			System.out.println(n - k);
			return;
		}

		int[] dp = new int[MAX_VALUE + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = n; i >= 0; i--) {
			dp[i] = n - i;
			if (n < i * 2 && i * 2 <= MAX_VALUE) {
				dp[i * 2] = Math.min(dp[i * 2 - 1], dp[i]) + 1;
			}
		}

		for (int i = n + 1; i <= MAX_VALUE; i++) {
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], Math.min(dp[i - 1], dp[i / 2]) + 1);
			} else {
				dp[i] = Math.min(dp[i - 1], dp[i + 1]) + 1;
			}
			if (i * 2 <= MAX_VALUE) {
				dp[i * 2] = dp[i] + 1;
			}
		}

		System.out.println(dp[k]);
	}
}
