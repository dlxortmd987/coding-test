package code_tree.intermidiate_low.Backtracking.순열_만들기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 수들의_합_최대화하기 {

	static int n;
	static int answer = Integer.MAX_VALUE;

	static int[][] g;
	static boolean[] v;
	static List<Integer> arr = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		g = new int[n][n];
		v = new boolean[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		arr.add(0);
		v[0] = true;
		func(0);

		System.out.println(answer);
	}

	private static void func(int cnt) {
		if (cnt == n - 1) {
			int sum = 0;
			for (int i = 0; i < arr.size() - 1; i++) {
				if (g[arr.get(i)][arr.get(i + 1)] == 0) {
					return;
				}
				sum += g[arr.get(i)][arr.get(i + 1)];
			}
			if (g[arr.get(arr.size() - 1)][0] == 0) {
				return;
			}
			sum += g[arr.get(arr.size() - 1)][0];

			answer = Math.min(answer, sum);
		}

		for (int i = 1; i < n; i++) {
			if (v[i])
				continue;

			v[i] = true;
			arr.add(i);
			func(cnt + 1);
			arr.remove(arr.size() - 1);
			v[i] = false;
		}
	}
}
