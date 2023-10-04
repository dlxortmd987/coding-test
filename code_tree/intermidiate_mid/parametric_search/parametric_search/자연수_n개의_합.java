package code_tree.intermidiate_mid.parametric_search.parametric_search;

import java.util.Scanner;

public class 자연수_n개의_합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long s = sc.nextLong();

		long res = find(s);
		if (res * (res + 1) / 2 == s) {
			System.out.println(res);
		} else {
			System.out.println(res - 1);
		}
	}

	private static long find(long k) {
		long s = 1;
		long e = k;
		long res = k + 1;
		while (s <= e) {
			long mid = (s + e) / 2;
			long t = mid * (mid + 1) / 2;
			if (t >= k) {
				e = mid - 1;
				res = Math.min(res, mid);
			} else {
				s = mid + 1;
			}
		}
		return res;
	}
}
