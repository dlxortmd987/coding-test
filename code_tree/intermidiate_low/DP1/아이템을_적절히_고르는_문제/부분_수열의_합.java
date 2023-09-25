package code_tree.intermidiate_low.DP1.아이템을_적절히_고르는_문제;

import java.util.Scanner;

public class 부분_수열의_합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		int[] dp = new int[m + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		dp[0] = 1;

		for (int i = 1; i <= m; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= m; j++) {
				if (j - arr[i] >= 0 && dp[j - arr[i]] > 0) {
					dp[j] += dp[j - arr[i]];
				}
			}
		}

		System.out.println(dp[m] > 0 ? "Yes" : "No");
	}
}
