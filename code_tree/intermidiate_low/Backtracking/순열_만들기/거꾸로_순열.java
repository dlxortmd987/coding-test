package code_tree.intermidiate_low.Backtracking.순열_만들기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 거꾸로_순열 {

	static int n;

	static boolean[] v;
	static List<Integer> arr = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		v = new boolean[n + 1];

		func(0);
	}

	private static void func(int cnt) {
		if (cnt == n) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.size(); i++) {
				sb.append(arr.get(i)).append(" ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = n; i >= 1; i--) {
			if (v[i])
				continue;

			v[i] = true;
			arr.add(i);
			func(cnt + 1);
			v[i] = false;
			arr.remove(arr.size() - 1);
		}
	}
}
