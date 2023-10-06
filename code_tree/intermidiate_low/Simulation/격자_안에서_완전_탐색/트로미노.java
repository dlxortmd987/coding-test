package code_tree.intermidiate_low.Simulation.격자_안에서_완전_탐색;

import java.util.Scanner;

public class 트로미노 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] g = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int cur = g[i][j];
				if (i < n - 1 && j < m - 1) {
					int a2 = g[i+1][j];
					int a3 = g[i][j+1];
					int a4 = g[i+1][j+1];
					sum = Math.max(sum, cur + a2 + a3);
					sum = Math.max(sum, a2 + a3 + a4);
					sum = Math.max(sum, cur + a2 + a4);
					sum = Math.max(sum, cur + a3 + a4);
				}
				if (j < m - 2) {
					int b2 = g[i][j+1];
					int b3 = g[i][j+2];
					sum = Math.max(sum, cur + b2 + b3);
				}
				if (i < n - 2) {
					int b2 = g[i+1][j];
					int b3 = g[i+2][j];
					sum = Math.max(sum, cur + b2 + b3);
				}
			}
		}

		System.out.println(sum);
	}
}
