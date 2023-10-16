package code_tree.intermidiate_low.Backtracking.N개중에_M개_고르기_Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class xor_결과_최대_만들기 {

	static int n;
	static int m;

	static List<Integer> arr = new ArrayList<>();
	static List<Integer> tarr = new ArrayList<>();

	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			tarr.add(sc.nextInt());
		}

		func(0, -1);

		System.out.println(answer);
	}

	private static void func(int cnt, int num) {
		if (cnt == m) {
			int k = arr.get(0);
			for (int i = 1; i < arr.size(); i++) {
				k ^= arr.get(i);
			}
			answer = Math.max(answer, k);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (num >= i)
				continue;
			arr.add(tarr.get(i));
			func(cnt + 1, i);
			arr.remove(arr.size() - 1);
		}
	}
}
