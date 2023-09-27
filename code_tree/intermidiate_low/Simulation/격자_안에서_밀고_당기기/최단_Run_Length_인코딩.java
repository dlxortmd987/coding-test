package code_tree.intermidiate_low.Simulation.격자_안에서_밀고_당기기;

import java.util.Scanner;

public class 최단_Run_Length_인코딩 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		char[] arr = a.toCharArray();

		int res = 10000;
		for (int i = 0; i < a.length(); i++) {
			// shift
			shift(arr);

			// 변환
			String str = convert(arr);

			res = Math.min(res, str.length());
		}

		System.out.println(res);
	}

	private static String convert(char[] arr) {
		StringBuilder sb = new StringBuilder();
		char prev = arr[0];
		int count = 1;
		for (int j = 1; j < arr.length; j++) {
			if (prev != arr[j]) {
				sb.append(prev).append(count);
				prev = arr[j];
				count = 1;
			} else {
				count++;
			}
		}
		sb.append(prev).append(count);
		String str = sb.toString();
		return str;
	}

	private static void shift(char[] arr) {
		char t = arr[arr.length - 1];
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = t;
	}
}
