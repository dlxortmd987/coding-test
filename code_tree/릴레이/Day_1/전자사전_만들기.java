package code_tree.릴레이.Day_1;

import java.util.Arrays;
import java.util.Scanner;

public class 전자사전_만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();

		String[][] arr = new String[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.next();
			arr[i][1] = String.valueOf(i + 1);
		}

		Arrays.sort(arr, (o1, o2) -> o1[0].compareTo(o2[0]));

		for (int i = 0; i < t; i++) {
			int k = sc.nextInt();
			String s = sc.next();
			int idx = find(s, arr, k);
			if (idx == -1)
				System.out.println(-1);
			else
				System.out.println(arr[idx][1]);
		}
	}

	private static int find(String str, String[][] arr, int k) {
		int s = 0;
		int e = arr.length;
		int res = arr.length;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid][0].startsWith(str) || arr[mid][0].compareTo(str) >= 0) {
				e = mid - 1;
				res = Math.min(res, mid);
			} else {
				s = mid + 1;
			}
		}

		if (res + k - 1 >= arr.length || !arr[res + k - 1][0].startsWith(str)) {
			return -1;
		} else {
			return res + k - 1;
		}
	}
}
