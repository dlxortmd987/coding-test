package code_tree.intermidiate_mid.prefix_sum;

import java.util.Scanner;

public class 정수_n개의_합_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i < n; i++) {
			arr[i] += arr[i - 1];
		}

		int res = -Integer.MAX_VALUE;
		for (int i = 0; i < n - k; i++) {
			res = Math.max(arr[i + k] - arr[i], res);
		}

		System.out.println(res);
	}
}
