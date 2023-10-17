package code_tree.intermidiate_low.Backtracking.N개중에_M개_고르기_Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 단순한_동전_챙기기 {

	static int n;

	static String[] g;
	static int[] s;
	static int[] e;

	static List<int[]> arr = new ArrayList<>();
	static List<int[]> tarr = new ArrayList<>();

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		g = new String[n];

		s = new int[2];
		e = new int[2];

		for (int i = 0; i < n; i++) {
			g[i] = sc.next();
			for (int j = 0; j < n; j++) {
				if (g[i].charAt(j) - '0' > 0 && g[i].charAt(j) - '0' < 10) {
					tarr.add(new int[] {j, i, g[i].charAt(j) - '0'});
				} else if (g[i].charAt(j) == 'S') {
					s[0] = j;
					s[1] = i;
				} else if (g[i].charAt(j) == 'E') {
					e[0] = j;
					e[1] = i;
				}
			}
		}

		if (tarr.size() < 3) {
			System.out.println(-1);
			return;
		}

		tarr.sort((o1, o2) -> o1[2] - o2[2]);

		func(0, 0);

		System.out.println(answer);
	}

	private static void func(int cnt, int cur) {
		if (cnt == 3) {
			int k = cal(s, arr.get(0));
			for (int i = 0; i < arr.size() - 1; i++) {
				k += cal(arr.get(i), arr.get(i + 1));
			}
			k += cal(arr.get(arr.size() - 1), e);

			answer = Math.min(answer, k);
			return;
		}

		for (int i = 0; i < tarr.size(); i++) {
			if (cur >= tarr.get(i)[2])
				continue;

			arr.add(tarr.get(i));
			func(cnt + 1, tarr.get(i)[2]);
			arr.remove(arr.size() - 1);
		}
	}

	private static int cal(int[] start, int[] destination) {
		return Math.abs(destination[1] - start[1]) + Math.abs(destination[0] - start[0]);
	}
}
