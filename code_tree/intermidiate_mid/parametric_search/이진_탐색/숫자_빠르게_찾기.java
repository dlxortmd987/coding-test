package code_tree.intermidiate_mid.parametric_search.이진_탐색;

import java.util.Scanner;

public class 숫자_빠르게_찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		int[] tarr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			int k = sc.nextInt();

			int res = find(k, arr);
			System.out.println(res);
		}

	}

	private static int find(int k, int[] arr) {
		int s = 0;
		int e = arr.length;
		int mid = (s + e) / 2;
		while (s < e) {
			if (arr[mid] == k)
				break;
			if (arr[mid] < k) {
				s = mid + 1;
			} else {
				e = mid;
			}
			mid = (s + e) / 2;
		}
		if (s >= e)
			return -1;
		return mid + 1;
	}
}
