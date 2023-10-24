package code_tree.intermidiate_mid.parametric_search.parametric_search;

import java.util.Scanner;

public class 이차원_배얼의_오름차순_정리 {

	static long n;
	static long k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextLong();
		k = sc.nextLong();

		System.out.println(find());
	}

	private static long find() {
		long s = 1L;
		long e = 1000_000_000L;
		long res = 1000_000_000L;
		while (s <= e) {
			long mid = (s + e) / 2;
			long sum = 0;
			for (long i = 1; i <= n; i++) {
				sum += Math.min(n, mid / i);
			}
			if (sum >= k) {
				e = mid - 1;
				res = Math.min(res, mid);
			} else {
				s = mid + 1;
			}
		}

		return res;
	}
}
