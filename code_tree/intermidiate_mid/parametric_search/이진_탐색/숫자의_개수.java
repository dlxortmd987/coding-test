package code_tree.intermidiate_mid.parametric_search.이진_탐색;

import java.util.Scanner;

public class 숫자의_개수 {
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
			int l = lower(tarr[i], arr);
			int h = higher(tarr[i], arr);
			System.out.println(h - l);
		}
	}

	private static int higher(int target, int[] arr) {
		int s = 0;
		int e = arr.length - 1;
		int midx = arr.length;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] > target) {
				e = mid - 1;
				midx = Math.min(midx, mid);
			} else {
				s = mid + 1;
			}
		}
		return midx;
	}

	private static int lower(int target, int[] arr) {
		int s = 0;
		int e = arr.length - 1;
		int midx = arr.length;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] >= target) {
				e = mid - 1;
				midx = Math.min(midx, mid);
			} else {
				s = mid + 1;
			}
		}
		return midx;
	}
}
