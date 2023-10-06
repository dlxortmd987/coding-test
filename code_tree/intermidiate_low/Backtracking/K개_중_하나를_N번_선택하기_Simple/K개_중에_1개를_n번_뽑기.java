package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class K개_중에_1개를_n번_뽑기 {

	static List<Integer> res = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int n = sc.nextInt();

		choose(k, n, 0);
	}

	private static void choose(int k, int n, int i) {
		if (res.size() == n) {
			for (Integer t : res) {
				System.out.printf("%d ", t);
			}
			System.out.println();
			return;
		}

		for (int j = 1; j <= k; j++) {
			res.add(j);
			choose(k, n, i + 1);
			res.remove(i);
		}
	}
}
