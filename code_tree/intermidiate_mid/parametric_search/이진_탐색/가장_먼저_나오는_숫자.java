package code_tree.intermidiate_mid.parametric_search.이진_탐색;

import java.util.Scanner;

public class 가장_먼저_나오는_숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		int[] tarr = new int[m];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			tarr[i] = sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			int res = find(tarr[i], arr);
			if (res >= arr.length || arr[res] != tarr[i]) {
				System.out.println(-1);
			} else {
				System.out.println(res + 1);
			}
		}
	}

	private static int find(int x, int[] arr) {
		int s = 0;
		int e = arr.length - 1;
		int res = arr.length;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] >= x) {
				e = mid - 1;
				res = Math.min(res, mid);
			} else {
				s = mid + 1;
			}
		}
		return res;
	}
}
