package code_tree.intermidiate_low.DP1.아이템을_적절히_고르는_문제;

import java.util.Scanner;

public class 부분_수열의_합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[m + 1];

		dp[0] = 0;
		for (int i = 1; i <= m; i++) {
			dp[i] = Integer.MIN_VALUE;
		}

		for (int i = 1; i < n; i++) {
			int num = arr[i];
			for (int j = m; j > 0; j--) {
				if (j >= num) {
					if (dp[j - num] == Integer.MIN_VALUE)
						continue;
					dp[j] = Math.max(dp[i], dp[j - num] + 1);
				}
			}
		}

		if (dp[m] >= 1)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
