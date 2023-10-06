package code_tree.intermidiate_low.Simulation.격자_안에서_완전_탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 양수_직사각형의_최대_크기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] g = new int[n][m];
		List<int[]> negatives = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = sc.nextInt();
				if (g[i][j] <= 0) {
					negatives.add(new int[] {j, i});
				}
			}
		}

		List<int[]> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int h = i; h < n; h++) {
					for (int k = j; k < m; k++) {
						arr.add(new int[] {j, i, k, h});
					}
				}
			}
		}

		int answer = -1;
		for (int[] i : arr) {
			int k = 0;
			boolean isIncluded = false;
			for (int[] negative : negatives) {
				if (negative[0] >= i[0] && negative[0] <= i[2] && negative[1] >= i[1] && negative[1] <= i[3]) {
					isIncluded = true;
					break;
				}
			}

			if (!isIncluded) {
				k = (i[2] - i[0] + 1) * (i[3] - i[1] + 1);

				answer = Math.max(k, answer);
			}
		}
		System.out.println(answer);
	}
}
