package backjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P_17626 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] dp = new int[50001];

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		System.out.println(dp[n]);
	}
}
