package code_tree.intermidiate_low.DP1.아이템을_적절히_고르는_문제;

import java.util.Scanner;

public class 일_이_오_더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		int[] a = {1, 2, 5};

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 3; j++) {
				if (i - a[j] >= 0) {
					dp[i] = (dp[i] + dp[i - a[j]]) % 10007;
				}
			}
		}

		System.out.println(dp[n]);
	}
}
