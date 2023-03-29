package programmers;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class test {
	public static String solution(String number, int k) {
		String answer = "";

		Stack<Integer> stack = new Stack<>();


		for (int i = 0; i < number.length(); i++) {
			int token = number.charAt(i) - '0';

			while (!stack.empty() && stack.peek() < token && k > 0) {
				stack.pop();
				k--;
			}
			stack.push(token);
		}

		if (k == 0) {
			answer = stack.stream()
				.map(Object::toString)
				.collect(Collectors.joining(""));
		} else {
			answer = stack.stream()
				.map(Objects::toString)
				.limit(stack.size()-k)
				.collect(Collectors.joining(""));
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("4177252841", 4));
	}
}
