package backjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class P_17413 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		char[] s = sc.nextLine().toCharArray();

		char[] res = new char[s.length];

		boolean isTag = false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length; i++) {
			char c = s[i];

			if (c == '<') {
				int idx = i - stack.size();
				while (!stack.isEmpty()) {
					res[idx] = stack.pop();
					idx++;
				}
				res[i] = ' ';
				isTag = true;
				res[i] = '<';
			} else if (c == '>') {
				isTag = false;
				res[i] = '>';
			} else if (c == ' ') {
				int idx = i - stack.size();
				while (!stack.isEmpty()) {
					res[idx] = stack.pop();
					idx++;
				}
				res[i] = ' ';
			} else if (isTag) {
				res[i] = c;
			} else if (!isTag) {
				stack.push(c);
			}
		}
		int idx = res.length - stack.size();
		while (!stack.isEmpty()) {
			res[idx] = stack.pop();
			idx++;
		}

		System.out.println(String.valueOf(res));
	}
}
