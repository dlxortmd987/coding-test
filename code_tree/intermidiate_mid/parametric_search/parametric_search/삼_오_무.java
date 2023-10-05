package code_tree.intermidiate_mid.parametric_search.parametric_search;

import java.util.Scanner;

public class 삼_오_무 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		long res = find(n);
		System.out.println(res);
	}

	private static long find(long n) {
		long s = 0L;
		long e = 10_000_000_000L;
		long res = e + 1;
		while (s <= e) {
			long mid = (s + e) / 2;
			long k = mid - mid / 3 - mid / 5 + mid / 15;
			System.out.printf("s: %d, e: %d, mid: %d, k: %d\n", s, e, mid, k);

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
