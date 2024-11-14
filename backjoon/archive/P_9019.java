package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int iv;
	String ops;

	public Node(int iv, String ops) {
		this.iv = iv;
		this.ops = ops;
	}
}

public class P_9019 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String[] line = br.readLine().split(" ");
			boolean[] v = new boolean[10000];

			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			System.out.println(bfs(a, b, v));
		}

		br.close();
	}

	private static String bfs(int a, int b, boolean[] v) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a, ""));
		v[a] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.iv == b)
				return cur.ops;

			int resD = (cur.iv * 2) % 10000;

			if (!v[resD]) {
				q.add(new Node(resD, cur.ops + "D"));
				v[resD] = true;
			}

			int resS = cur.iv - 1 < 0 ? 9999 : cur.iv - 1;

			if (!v[resS]) {
				q.add(new Node(resS, cur.ops + "S"));
				v[resS] = true;
			}

			int resL = (cur.iv % 1000) * 10 + cur.iv / 1000;

			if (!v[resL]) {
				q.add(new Node(resL, cur.ops + "L"));
				v[resL] = true;
			}

			int resR = (cur.iv / 10) + (cur.iv % 10) * 1000;

			if (!v[resR]) {
				q.add(new Node(resR, cur.ops + "R"));
				v[resR] = true;
			}
		}

		return "";
	}
}
