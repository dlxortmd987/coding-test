package code_tree.intermidiate_low.Simulation.격자_안에서_밀고_당기기;

import java.util.Scanner;

public class 컨베이어_벨트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();

		int[] arr1 = new int[n];
		int[] arr2 = new int[n];

		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}

		int t1 = 0;
		int t2 = 0;

		while (t > 0) {
			t1 = arr1[arr1.length - 1];
			t2 = arr2[arr2.length - 1];
			for (int i = n - 1; i > 0; i--) {
				arr1[i] = arr1[i - 1];
			}
			arr1[0] = t2;

			for (int i = n - 1; i > 0; i--) {
				arr2[i] = arr2[i - 1];
			}
			arr2[0] = t1;
			t--;
		}

		for (int i = 0; i < n; i++) {
			System.out.printf("%d ", arr1[i]);
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.printf("%d ", arr2[i]);
		}
	}
}
