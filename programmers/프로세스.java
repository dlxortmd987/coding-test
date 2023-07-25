package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {

	public static int solution(int[] priorities, int location) {
		int answer = 0;

		int[] p = new int[10];
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			int k = priorities[i];
			p[k] += 1;
			q.add(new int[] {i, k});
		}



		while (!q.isEmpty()) {
			int[] cur = q.poll();
			boolean isFirst = true;
			for (int i = cur[1]+1; i < 10; i++) {
				if (p[i] > 0) {
					isFirst = false;
					break;
				}
			}

			if (!isFirst) {
				q.add(cur);
			} else {
				if (cur[0] == location) {
					return answer;
				}
				answer++;
				p[cur[1]] -= 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] arr1 = {2, 1, 3, 2};
		int[] arr2 = {1, 1, 9, 1, 1, 1};
		solution(arr1, 2);
		solution(arr2, 0);
	}
}
