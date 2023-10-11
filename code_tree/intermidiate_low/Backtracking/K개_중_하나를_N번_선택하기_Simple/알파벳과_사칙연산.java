package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 알파벳과_사칙연산 {

	static String s;
	static int answer = 0;

	static List<Integer> arr = new ArrayList<>();
	static Map<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.next();

		for (int i = 0; i < s.length(); i++) {
			if (0 <= s.charAt(i) - 'a' && s.charAt(i) - 'a' <= 6) {
				map.put(s.charAt(i), 0);
			}
		}

		func(0);

		System.out.println(answer);
	}

	private static void func(int cnt) {
		if (cnt == map.size()) {
			answer = Math.max(answer, getRes());
			return;
		}

		for (int i = 1; i <= 4; i++) {
			arr.add(i);
			func(cnt + 1);
			arr.remove(arr.size() - 1);
		}
	}

	private static int getRes() {
		int cnt = 0;
		for (Character c : map.keySet()) {
			map.put(c, arr.get(cnt));
			cnt++;
		}

		int res = map.get(s.charAt(0));
		char operator = '0';
		for (int i = 1; i < s.length(); i++) {
			if (0 <= s.charAt(i) - 'a' && s.charAt(i) - 'a' <= 6) {
				int rhs = map.get(s.charAt(i));
				if (operator == '+') {
					res += rhs;
				} else if (operator == '-') {
					res -= rhs;
				} else if (operator == '*') {
					res *= rhs;
				} else if (operator == '/') {
					res /= rhs;
				}
			} else {
				operator = s.charAt(i);
			}
		}

		return res;
	}
}
