package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_17779 {

	static int n;
	static int[][] g;
	static int[][] number;
	static int[] people = new int[5];

	static int[][] d = {{-1, 1}, {1, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		g = new int[n][n];
		number = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				g[i][j] = Integer.parseInt(line[j]);
			}
		}

		int res = Integer.MAX_VALUE;

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				for (int d1 = 1; d1 < n; d1++) {
					if (y < d1)
						break;
					for (int d2 = 1; d2 < n; d2++) {
						if (x > n - d1 - d2 - 1 || y > n - d2 - 1)
							break;

						int r = x;
						int c = y;
						number[r][c] = 5;
						for (int i = 1; i <= d1; i++) {
							r += d[0][1];
							c += d[0][0];

							number[r][c] = 5;
							number[r + d2][c + d2] = 5;
						}
						r = x;
						c = y;
						for (int i = 1; i <= d2; i++) {
							r += d[1][1];
							c += d[1][0];

							number[r][c] = 5;
							number[r + d1][c - d1] = 5;
						}

						boolean isInFive = false;
						for (int i = x + 1; i < x + d1 + d2; i++) {
							for (int j = 0; j < n; j++) {
								if (isInFive && number[i][j] == 5) {
									isInFive = false;
									break;
								} else if (isInFive && number[i][j] != 5) {
									number[i][j] = 5;
								} else if (!isInFive && number[i][j] == 5) {
									isInFive = true;
								}
							}
						}

						for (int i = 0; i < n; i++) {
							for (int j = 0; j < n; j++) {
								if (number[i][j] == 5) {
									people[4] += g[i][j];
								} else if (i < x + d1 && j <= y) {
									people[0] += g[i][j];
								} else if (i <= x + d2 && y < j) {
									people[1] += g[i][j];
								} else if (x + d1 <= i && j < y - d1 + d2) {
									people[2] += g[i][j];
								} else {
									people[3] += g[i][j];
								}
							}
						}
						Arrays.sort(people);
						res = Math.min(res, people[4] - people[0]);

						Arrays.fill(people, 0);

						for (int i = 0; i < n; i++) {
							Arrays.fill(number[i], 0);
						}
					}
				}
			}
		}

		System.out.println(res);
		br.close();
	}
}
