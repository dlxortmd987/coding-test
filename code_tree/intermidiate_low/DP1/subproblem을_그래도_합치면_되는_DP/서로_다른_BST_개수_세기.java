package code_tree.intermidiate_low.DP1.subproblem을_그래도_합치면_되는_DP;

import java.util.Scanner;

public class 서로_다른_BST_개수_세기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] dp = new int[20];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		if (n <= 2) {
			System.out.println(dp[n]);
			return;
		}

		for (int i = 3; i <= n; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += dp[j]*dp[i-j-1];
			}
			dp[i] = sum;
		}
		System.out.println(dp[n]);
	}
}
