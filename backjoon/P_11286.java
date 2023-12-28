package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0])
				return o1[1] - o2[1];
			return o1[0] - o2[0];
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x != 0) {
				pq.add(new int[] {Math.abs(x), x});
				continue;
			}

			if (pq.isEmpty()) {
				sb.append(0).append('\n');
				continue;
			}

			sb.append(pq.poll()[1]).append('\n');
		}

		System.out.println(sb);

		br.close();
	}
}
