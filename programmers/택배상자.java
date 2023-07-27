package programmers;

import java.util.*;

public class 택배상자 {
	public int solution(int[] order) {
		int answer = 0;

		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		Set<Integer> set = new HashSet<>();

		for (int i = 1; i <= order.length; i++) {
			q.add(i);
		}

		int cur = 0;
		while (cur < order.length) {
			if (!q.isEmpty() && q.peek() == order[cur]) {
				answer++;
				cur++;
				q.poll();
			} else if (!s.empty() && s.peek() == order[cur]) {
				answer++;
				cur++;
				s.pop();
			} else {
				if (set.contains(order[cur])) break;
				int k = q.poll();
				s.add(k);
				set.add(k);
			}
			// System.out.printf("answer: %d, cur: %d, q: %s, s: %s, set: %s\n", answer, cur, q, s, set);
		}

		return answer;
	}
}
