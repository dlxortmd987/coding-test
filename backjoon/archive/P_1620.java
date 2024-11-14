package backjoon.archive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P_1620 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		Map<String, Integer> ni = new HashMap<>();
		Map<Integer, String> in = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String name = sc.next();
			ni.put(name, i);
			in.put(i, name);
		}

		for (int i = 0; i < m; i++) {
			String str = sc.next();
			if (ni.containsKey(str)) {
				System.out.println(ni.get(str));
			} else {
				System.out.println(in.get(Integer.parseInt(str)));
			}
		}
	}
}
