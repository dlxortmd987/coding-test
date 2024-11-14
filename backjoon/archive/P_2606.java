package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P_2606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		int[][] g = new int[n][n];
		for (int i = 0; i < t; i++) {
			String[] raw = br.readLine().split(" ");
			int a = Integer.parseInt(raw[0]) - 1;
			int b = Integer.parseInt(raw[1]) - 1;
			g[a][b] = 1;
			g[b][a] = 1;
		}

		int count = bfs(g, 0);

		System.out.println(count);

		br.close();
	}

	private static int bfs(int[][] g, int target) {
		int count = 0;
		boolean[] v = new boolean[g.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(target);
		v[target] = true;

		while (!q.isEmpty()) {
			int k = q.poll();

			for (int i = 0; i < g.length; i++) {
				if (!v[i] && g[k][i] == 1) {
					q.add(i);
					v[i] = true;
					count++;
				}
			}
		}

		return count;
	}
}
