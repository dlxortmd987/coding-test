package code_tree.intermidiate_low.DP1.아이템을_적절히_고르는_문제;

import java.util.Scanner;

public class 배낭_채우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int[] dp = new int[m + 1];

		dp[0] = 0;
		for (int i = 1; i <= m; i++) {
			dp[i] = Integer.MIN_VALUE;
		}

		for (int i = 0; i < n; i++) {
			int num = arr[i][0];
			for (int j = m; j >= num; j--) {
				dp[j] = Math.max(dp[j], dp[j - num] + arr[i][1]);
			}
		}

		int res = 0;
		for (int i = 0; i <= m; i++) {
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}
}
