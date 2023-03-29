package backjoon;

import java.util.Scanner;

class Main9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[12];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		for (int i = 4; i < 12; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}

		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			System.out.println(arr[k]);
		}
	}
}