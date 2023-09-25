package code_tree.intermidiate_low.Simulation.격자_안에서_밀고_당기기;

import java.util.Scanner;

public class 삼각형_컨베이어_벨트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		int[] tarr = new int[3];

		int[][] arr = new int[3][n];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		while (t > 0) {
			for (int i = 0; i < 3; i++) {
				tarr[i] = arr[i][n - 1];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = n - 1; j > 0; j--) {
					arr[i][j] = arr[i][j - 1];
				}
				if (i == 0) {
					arr[0][0] = tarr[2];
				} else {
					arr[i][0] = tarr[i - 1];
				}
			}
			t--;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
