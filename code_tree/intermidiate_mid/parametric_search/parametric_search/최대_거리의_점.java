package code_tree.intermidiate_mid.parametric_search.parametric_search;

import java.util.Arrays;
import java.util.Scanner;

public class 최대_거리의_점 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		System.out.println(find(n, m, arr));
	}

	private static int find(int n, int m, int[] arr) {

		int s = 0;
		int e = Integer.MAX_VALUE;
		int res = 0;
		while (s <= e) {
			int mid = (s + e) / 2;
			int count = 1;
			int l = 0;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] - arr[l] >= mid) {
					count++;
					l = i;
				}
			}
			if (count >= m) {
				s = mid + 1;
				res = Math.max(res, mid);
			} else {
				e = mid - 1;
			}
		}

		return res;
	}

}
