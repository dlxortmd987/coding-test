package code_tree.intermidiate_mid.parametric_search.parametric_search;

import java.util.Scanner;

public class 최소_통과_시간 {

	static int n;
	static int m;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = sc.nextInt();
		}

		long res = find();
		System.out.println(res);
	}

	private static long find() {
		long s = 0;
		long e = Long.MAX_VALUE;
		long res = e;

		while (s <= e) {
			long mid = (s + e) / 2;
			long k = 0;
			for (int i = 0; i < m; i++) {
				k += mid / (long)arr[i];
			}
			if (k >= n) {
				e = mid - 1;
				res = Math.min(res, mid);
			} else {
				s = mid + 1;
			}

		}

		return res;
	}
}
