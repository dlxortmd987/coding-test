package code_tree.intermidiate_low.Backtracking.N개중에_M개_고르기_Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class n개_중에_m개_뽑기 {

	static int n;
	static int m;

	static List<Integer> arr = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		func(0, 0);
	}

	private static void func(int cnt, int num) {
		if (cnt == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.size(); i++) {
				sb.append(arr.get(i)).append(" ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (num >= i)
				continue;
			arr.add(i);
			func(cnt + 1, i);
			arr.remove(arr.size() - 1);
		}
	}
}
