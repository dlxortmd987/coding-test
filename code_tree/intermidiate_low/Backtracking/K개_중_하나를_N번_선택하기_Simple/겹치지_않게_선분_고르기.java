package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 겹치지_않게_선분_고르기 {

	static int n;
	static int answer;
	static int[][] g;

	static List<int[]> arr = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		g = new int[n][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				g[i][j] = sc.nextInt();
			}
		}

		func(0);

		System.out.println(answer);
	}

	private static void func(int cnt) {
		if (cnt == n) {
			if (possible()) {
				answer = Math.max(answer, arr.size());
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
				if (overlapped(arr.get(i), arr.get(j)))
					return false;
			}

		}
		return true;
	}

	private static boolean overlapped(int[] s1, int[] s2) {
		return (s1[0] <= s2[0] && s2[0] <= s1[1]) || (s2[1] <= s1[1] && s1[0] <= s2[1]) ||
			(s2[0] <= s1[0] && s1[0] <= s2[0]) || (s2[0] <= s1[1] && s1[1] <= s2[1]);
	}

}
