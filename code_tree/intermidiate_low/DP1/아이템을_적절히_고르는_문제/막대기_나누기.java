package code_tree.intermidiate_low.DP1.아이템을_적절히_고르는_문제;

import java.util.Scanner;

public class 막대기_나누기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i + 1] = arr[i];
		}
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
			}
		}

		int res = 0;
		for (int i = 0; i <= n; i++) {
			res = Math.max(res, dp[n]);
		}

		System.out.println(res);
	}
}
