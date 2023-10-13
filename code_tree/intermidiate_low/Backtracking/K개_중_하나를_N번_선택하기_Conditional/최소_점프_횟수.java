package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Conditional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 최소_점프_횟수 {

	static int n;
	static int answer = Integer.MAX_VALUE;

	static int[] arr;

	static List<Integer> res = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		res.add(0);

		func();

		if (answer == Integer.MAX_VALUE)
			answer = -1;
		System.out.println(answer);
	}

	private static void func() {
		int idx = res.get(res.size() - 1);
		if (idx == n - 1) {
			answer = Math.min(answer, res.size() - 1);
			return;
		}

		for (int i = 1; i <= arr[idx]; i++) {
			if (idx + i >= n)
				break;

			res.add(idx + i);
			func();
			res.remove(res.size() - 1);
		}
	}
}
