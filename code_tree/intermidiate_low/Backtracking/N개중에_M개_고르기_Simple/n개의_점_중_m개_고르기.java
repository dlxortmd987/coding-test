package code_tree.intermidiate_low.Backtracking.N개중에_M개_고르기_Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class n개의_점_중_m개_고르기 {

	static int n;
	static int m;

	static List<int[]> arr = new ArrayList<>();
	static List<int[]> g = new ArrayList<>();

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int[] c = new int[2];
			c[0] = sc.nextInt();
			c[1] = sc.nextInt();
			g.add(c);
		}

		func(0, -1);

		System.out.println(answer);
	}

	private static void func(int cnt, int cur) {
		if (cnt == m) {
			int k = 0;
			for (int i = 0; i < arr.size(); i++) {
				int[] p1 = arr.get(i);
				for (int j = i + 1; j < arr.size(); j++) {
					int[] p2 = arr.get(j);

					k = Math.max(k, calc(p1, p2));
				}
			}

			answer = Math.min(answer, k);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (cur >= i)
				continue;

			arr.add(g.get(i));
			func(cnt + 1, i);
			arr.remove(arr.size() - 1);
		}
	}

	private static int calc(int[] p1, int[] p2) {
		return (int)(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
	}
}
