package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P_1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());

			if (pq.size() == 0 && x == 0) {
				System.out.println(0);
				continue;
			}

			if (x == 0) {
				System.out.println(pq.poll());
			} else {
				pq.add(x);
			}
		}

		br.close();
	}
}
