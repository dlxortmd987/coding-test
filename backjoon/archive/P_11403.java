package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_11403 {

	static int[][] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] g = new int[n][n];
		res = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				g[i][j] = Integer.parseInt(line[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			boolean[] v = new boolean[n];
			bfs(i, v, g);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(res[i][j]).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);

		br.close();
	}

	private static void bfs(int i, boolean[] v, int[][] g) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		List<Integer> arr = new ArrayList<>();

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int j = 0; j < g.length; j++) {
				if (g[cur][j] == 1 && !v[j]) {
					q.add(j);
					v[j] = true;
					arr.add(j);
				}
			}
		}

		for (int j = 0; j < arr.size(); j++) {
			res[i][arr.get(j)] = 1;
		}
	}
}
