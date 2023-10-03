package code_tree.intermidiate_mid.parametric_search.이진_탐색;

import java.util.Scanner;

public class 컴퓨터와_함께하는_숫자_게임_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long m = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();

		long min = Long.MAX_VALUE;
		long max = 0;
		for (long i = a; i <= b; i++) {
			long count = find(m, i);
			min = Math.min(min, count);
			max = Math.max(max, count);
		}
		System.out.printf("%d %d\n", min, max);
	}

	private static long find(long m, long i) {
		long s = 1;
		long e = m;
		int res = 0;

		while (s <= e) {
			long mid = (s + e) / 2;
			res++;
			if (mid == i) {
				return res;
			} else if (mid < i) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return res;
	}

}
