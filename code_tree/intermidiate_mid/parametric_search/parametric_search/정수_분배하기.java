package code_tree.intermidiate_mid.parametric_search.parametric_search;

import java.util.Scanner;

public class 정수_분배하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int k = 200_000;
		int res = find(k, arr, m);
		System.out.println(res - 1);
	}

	private static int find(int k, int[] arr, int m) {
		int s = 1;
		int e = k;
		int res = k + 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				count += arr[i] / mid;
			}
			if (count < m) {
				e = mid - 1;
				res = Math.min(res, mid);
			} else {
				s = mid + 1;
			}
		}
		return res;
	}
}
