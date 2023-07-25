package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		Queue<int[]> q = new LinkedList<>();
		int idx = 0;
		int cur = 0;
		for (int i = 1;i <= bridge_length * truck_weights.length + 1; i++) {
			if (idx == truck_weights.length) break;

			if (q.isEmpty()) {
				q.add(new int[] {i + bridge_length, truck_weights[idx]});
				cur += truck_weights[idx];
				idx++;
				continue;
			}

			int[] k = q.peek();
			if (k[0] == i) {
				q.poll();
				cur -= k[1];
			}

			if (cur + truck_weights[idx] <= weight) {
				cur += truck_weights[idx];
				q.add(new int[]{i + bridge_length, truck_weights[idx]});
				idx++;
			}
		}
		int answer = 0;
		while (!q.isEmpty()) {
			answer = q.poll()[0];
		}

		return answer;
	}

	public static void main(String[] args) {
		solution(2, 10, new int[] {7, 4, 5, 6});
		solution(100, 100, new int[] {10});
		solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
	}
}
