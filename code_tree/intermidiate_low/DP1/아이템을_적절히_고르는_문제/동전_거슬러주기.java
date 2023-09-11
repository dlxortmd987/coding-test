package code_tree.intermidiate_low.DP1.아이템을_적절히_고르는_문제;

import java.util.Scanner;

public class 동전_거슬러주기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int[] dp = new int[10001];
		dp[0] = 0;

		for (int i = 1; i <= m; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (i - a[j] >= 0 && dp[i - a[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - a[j]] + 1);
				}
			}
		}

		System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
	}
}
