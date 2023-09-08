package code_tree.intermidiate_low.DP1.조건에_맞게_선택적으로_전진하는_DP;

import java.util.Scanner;

public class 최대_점프_횟수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] m = new int[n];
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		int[] dp = new int[n];
		dp[0] = 0;

		int answer = dp[0];
		for (int i = 1; i < n; i++) {
			int k = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (i - j <= m[j]) {
					k = Math.max(k, dp[j]);
				}
			}
			if (k == Integer.MIN_VALUE) {
				System.out.println(answer);
				return;
			}
			dp[i] = k + 1;
			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}
