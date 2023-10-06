package code_tree.intermidiate_low.Simulation.격자_안에서_완전_탐색;

import java.util.Scanner;

public class 행복한_수열의_개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] g = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			int prev1 = g[i][0];
			int count1 = 1;
			int prev2 = g[0][i];
			int count2 = 1;
			int max1 = count1;
			int max2 = count2;
			for (int j = 1; j < n; j++) {
				if (prev1 == g[i][j]) {
					count1++;
				} else {
					count1 = 1;
					prev1 = g[i][j];
				}
				if (prev2 == g[j][i]) {
					count2++;
				} else {
					count2 = 1;
					prev2 = g[j][i];
				}
				max1 = Math.max(max1, count1);
				max2 = Math.max(max2, count2);
			}
			if (max1 >= m) answer++;
			if (max2 >= m) answer++;
		}

		System.out.println(answer);
	}
}
