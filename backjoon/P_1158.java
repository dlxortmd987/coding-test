package backjoon;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P_1158 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		Deque<Integer> dq = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			dq.add(i + 1);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (true) {
			if (dq.size() == 1) {
				sb.append(dq.poll()).append(">");
				break;
			}

			for (int i = 0; i < k - 1; i++) {
				dq.add(dq.poll());
			}
			sb.append(dq.poll()).append(", ");
		}

		System.out.println(sb);
	}
}
