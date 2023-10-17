package code_tree.intermidiate_low.Backtracking.N개중에_M개_고르기_Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 이n개_중에_n개의_숫자를_적절하게_고르기 {

	static int n;

	static List<Integer> arr = new ArrayList<>();
	static boolean[] v;

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		v = new boolean[2 * n];

		for (int i = 0; i < 2 * n; i++) {
			arr.add(sc.nextInt());
		}

		func(0, -1);

		System.out.println(answer);
	}

	private static void func(int cnt, int cur) {
		if (cnt == n) {
			int group1 = 0;
			int group2 = 0;
			for (int i = 0; i < arr.size(); i++) {
				if (v[i]) {
					group1 += arr.get(i);
				} else {
					group2 += arr.get(i);
				}
			}

			answer = Math.min(answer, Math.abs(group2 - group1));
			return;
		}

		for (int i = 0; i < 2 * n; i++) {
			if (cur >= i)
				continue;

			v[i] = true;
			func(cnt + 1, i);
			v[i] = false;
		}
	}
}
