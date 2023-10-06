package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Simple;

import java.util.Scanner;

public class 아름다운_수 {

	static int n;
	static int count;
	static String[] token = {"1", "22", "333", "4444"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		choose("");
		System.out.println(count);
	}

	private static void choose(String s) {
		if (s.length() >= n) {
			if (s.length() == n) {
				count++;
			}
			return;
		}

		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < token.length; i++) {
			sb.append(token[i]);
			choose(sb.toString());
			sb.delete(sb.length() - token[i].length(), sb.length());
		}

	}

}
