package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Conditional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 특정_조건에_맞게_k개_중에_1개를_n번_뽑기 {

	static int k;
	static int n;

	static List<Integer> arr = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		k = sc.nextInt();
		n = sc.nextInt();

		func(0);
	}

	private static void func(int cnt) {
		if (cnt == n) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.size(); i++) {
				sb.append(arr.get(i)).append(' ');
			}
			System.out.println(sb);
			return;
		}

		for (int i = 1; i <= k; i++) {
			if (arr.size() < 2 || arr.get(arr.size() - 2) != i || arr.get(arr.size() - 1) != i) {
				arr.add(i);
				func(cnt + 1);
				arr.remove(arr.size() - 1);
			}
		}
	}
}
