package code_tree.intermidiate_low.Backtracking.K개_중_하나를_N번_선택하기_Conditional;

import java.util.Scanner;

public class 가능한_수열_중_최솟값_구하기 {

	static int n;
	static String answer;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		func(0);

		System.out.println(answer);
	}

	private static void func(int cnt) {
		if (cnt == n) {
			answer = sb.toString();
			return;
		}

		for (int i = 4; i <= 6; i++) {
			sb.append(i);
			if (answer == null && possible()) {
				func(cnt + 1);
			}
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static boolean possible() {
		for (int i = 1; i <= sb.length() / 2; i++) {
			String str1 = sb.substring(sb.length() - i, sb.length());
			String str2 = sb.substring(sb.length() - i * 2, sb.length() - i);

			if (str1.equals(str2))
				return false;
		}
		return true;
	}

}
