package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 사다리_타기 {

	static int n;
	static int m;
	static int answer = Integer.MAX_VALUE;
	static int[][] g;

	static List<int[]> arr = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		g = new int[m][2];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 2; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		func(0);

		System.out.println(answer);
	}

	private static void func(int cnt) {
		if (cnt == m) {
			if (possible()) {
				answer = Math.min(answer, arr.size());
			}
			return;
		}

		arr.add(g[cnt]);
		func(cnt + 1);
		arr.remove(arr.size() - 1);

		func(cnt + 1);
	}

	private static boolean possible() {
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				int[] arr1 = arr.get(i);
				int[] arr2 = arr.get(j);
				if ((arr2[0] == arr1[0] + 1) && (arr1[1] == arr2[1])) {
					return false;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			int cur = i + 1;
			int scur = i + 1;
			for (int j = 0; j <= 15; j++) {
				for (int k = 0; k < m; k++) {
					if (g[k][0] == cur && g[k][1] == j) {
						cur++;
					} else if (g[k][0] == cur - 1 && g[k][1] == j) {
						cur--;
					}
				}
				for (int k = 0; k < arr.size(); k++) {
					int[] arr1 = arr.get(k);
					if (arr1[0] == scur && arr1[1] == j) {
						scur++;
					} else if (arr1[0] == scur - 1 && arr1[1] == j) {
						scur--;
					}
				}
			}
			if (cur != scur)
				return false;
		}
		return true;
	}

}
