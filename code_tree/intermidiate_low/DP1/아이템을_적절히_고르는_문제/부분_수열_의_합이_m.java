package code_tree.intermidiate_low.DP1.아이템을_적절히_고르는_문제;

import java.util.Scanner;

public class 부분_수열_의_합이_m {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int[] dp = new int[m + 1];

		for (int i = 0; i <= m; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = m; j > 0; j--) {
				if (j - a[i] >= 0 && dp[j - a[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - a[i]] + 1);
				}
			}
		}

		System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
	}
}
