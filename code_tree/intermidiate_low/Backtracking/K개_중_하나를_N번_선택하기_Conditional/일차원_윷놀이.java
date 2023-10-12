package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Conditional;

import java.util.Scanner;

public class 일차원_윷놀이 {

	static int n;
	static int m;
	static int k;
	static int answer = 0;

	static int[] h;

	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();

		arr = new int[k];
		h = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = sc.nextInt();
		}

		func(0);

		System.out.println(answer);
	}

	private static void func(int cnt) {
		if (cnt == n) {
			int cur = 0;
			for (int i = 0; i < k; i++) {
				if (arr[i] == m - 1)
					cur++;
			}
			answer = Math.max(answer, cur);
			return;
		}

		for (int i = 0; i < k; i++) {
			if (arr[i] + h[cnt] >= m - 1) {
				int t = arr[i];
				arr[i] = m - 1;
				func(cnt + 1);
				arr[i] = t;
			} else {
				arr[i] += h[cnt];
				func(cnt + 1);
				arr[i] -= h[cnt];
			}
		}
	}
}
