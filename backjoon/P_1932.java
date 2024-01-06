package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
			for (int j = line.length; j < n; j++) {
				arr[i][j] = -1;
			}
		}

		int[][] dp = new int[n][n];

		int[][] d = {{-1, -1}, {0, -1}};
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				for (int k = 0; k < 2; k++) {
					int y = d[k][1] + i;
					int x = d[k][0] + j;

					if (x < 0 || y < 0 || x >= i)
						continue;

					dp[i][j] = Math.max(dp[i][j], dp[y][x]);
				}
				dp[i][j] += arr[i][j];
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, dp[n - 1][i]);
		}

		System.out.println(res);

		br.close();
	}
}
