package backjoon.archive;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P_1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		Queue<Integer> queue = new LinkedList<>();

		int idx = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				queue.add(Integer.parseInt(str.substring(idx, i)));
				if (str.charAt(i) == '+')
					queue.add(-1);
				else
					queue.add(-2);
				idx = i + 1;
			}
		}
		queue.add(Integer.parseInt(str.substring(idx)));

		Stack<Integer> s = new Stack<>();
		s.push(queue.poll());
		while (!queue.isEmpty()) {
			int k = queue.poll();
			if (k == -1) {
				s.push(s.pop() + queue.poll());
				continue;
			}

			if (k == -2) {
				s.push(queue.poll());
			}
		}

		int sum = 0;
		while (s.size() > 1) {
			sum -= s.pop();
		}
		sum += s.pop();

		System.out.println(sum);
	}
}
