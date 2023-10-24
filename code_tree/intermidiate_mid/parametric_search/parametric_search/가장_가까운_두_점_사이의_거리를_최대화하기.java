package code_tree.intermidiate_mid.parametric_search.parametric_search;

import java.util.Arrays;
import java.util.Scanner;

public class 가장_가까운_두_점_사이의_거리를_최대화하기 {
	static int n;
	static int m;
	static long[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		arr = new long[m][2];

		for (int i = 0; i < m; i++) {
			arr[i][0] = sc.nextLong();
			arr[i][1] = sc.nextLong();
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] > o2[1])
				return 1;
			else if (o1[1] < o2[1])
				return -1;
			return 0;
		});

		long res = find();

		System.out.println(res);
	}

	private static long find() {
		long s = 0;
		long e = (long)1e18;
		long res = 0;

		while (s <= e) {
			long mid = (s + e) / 2;

			int cnt = 0;
			long lastX = -(long)1e18;

			for (int i = 0; i < m; i++) {
				long a = arr[i][0];
				long b = arr[i][1];

				while (lastX + mid <= b) {
					cnt++;
					lastX = Math.max(a, lastX + mid);

					if (cnt >= n)
						break;
				}
			}

			if (cnt < n) {
				e = mid - 1;
			} else {
				s = mid + 1;
				res = Math.max(res, mid);
			}
		}
		return res;
	}
}
