package backjoon;

import java.io.IOException;
import java.util.Scanner;

public class P_1904 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] dp = new int[1000001];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}

		System.out.println(dp[n]);
	}
}
