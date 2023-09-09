package code_tree.intermidiate_low.DP1.조건에_맞게_선택적으로_전진하는_DP;

import java.util.Arrays;
import java.util.Scanner;

public class 알바로_부자_되기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] a = new int[n][3];

		for (int i = 0; i < n; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
			a[i][2] = sc.nextInt();
		}

		Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);

		long[] dp = new long[1000];

		long answer = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = (long)a[i][2];

			for (int j = 0; j < i; j++) {
				if (a[j][1] < a[i][0]) {
					dp[i] = Math.max(dp[i], dp[j] + (long)a[i][2]);
				}
			}

			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}
