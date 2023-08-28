package code_tree.intermidiate_low.Backtracking.격자_안에서_완전_탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 겹쳐지지_않는_두_직사각형 {
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

		List<int[][]> res = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				if (arr.get(j)[2] < arr.get(i)[0]
					|| arr.get(i)[2] < arr.get(j)[0]
					|| arr.get(j)[3] < arr.get(i)[1]
					|| arr.get(i)[3] < arr.get(j)[1]) {
					res.add(new int[][] {arr.get(i), arr.get(j)});
				}
			}
		}

		int answer = -1 * Integer.MAX_VALUE;
		for (int[][] r : res) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if ((i >= r[0][1] && i <= r[0][3] && j >= r[0][0] && j <= r[0][2])
						|| (i >= r[1][1] && i <= r[1][3] && j >= r[1][0] && j <= r[1][2])) {
						sum += g[i][j];
					}
				}
			}
			if (answer < sum) {
				System.out.println("sum = " + sum + ", answer = " + answer + ", r: " + Arrays.deepToString(r));
				answer = sum;
			}
			// answer = Math.max(sum, answer);
		}

		System.out.println(answer);
	}
}
