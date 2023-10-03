package code_tree.intermidiate_mid.parametric_search.이진_탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 선분_위의_점 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		int[][] tarr = new int[m][2];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < m; i++) {
			tarr[i][0] = sc.nextInt();
			tarr[i][1] = sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			int l = lower(arr, tarr[i][0]);
			int u = upper(arr, tarr[i][1]);
			System.out.println(u - l);
		}
	}

	private static int upper(int[] arr, int i) {
		int s = 0;
		int e = arr.length - 1;
		int res = arr.length;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] > i) {
				e = mid - 1;
				res = Math.min(res, mid);
			} else {
				s = mid + 1;
			}
		}
		return res;
	}

	private static int lower(int[] arr, int i) {
		int s = 0;
		int e = arr.length - 1;
		int res = arr.length;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] >= i) {
				e = mid - 1;
				res = Math.min(res, mid);
			} else {
				s = mid + 1;
			}
		}
		return res;
	}
}
