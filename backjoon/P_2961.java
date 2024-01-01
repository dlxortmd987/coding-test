package backjoon;

import java.io.IOException;
import java.util.Scanner;

public class P_2961 {

	static long res = Integer.MAX_VALUE;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int b = sc.nextInt();

			arr[i][0] = s;
			arr[i][1] = b;
		}

		func(0, n, 1, 0);

		System.out.println(res);
	}

	private static void func(int cur, int n, int s, int b) {
		if (cur == n) {
			if (s != 1 && b != 0)
				res = Math.min(res, Math.abs(s - b));
			return;
		}

		func(cur + 1, n, s, b);
		func(cur + 1, n, s * arr[cur][0], b + arr[cur][1]);
	}
}
