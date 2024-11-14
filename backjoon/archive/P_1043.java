package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P_1043 {

	static int[][] g;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");

		n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		g = new int[n + 1][n + 1];

		String[] know = br.readLine().split(" ");

		int kn = Integer.parseInt(know[0]);

		Set<Integer> kSet = new HashSet<>();
		for (int i = 0; i < kn; i++) {
			kSet.add(Integer.parseInt(know[i + 1]));
		}

		int[][] arr = new int[m][50];
		for (int i = 0; i < m; i++) {
			String[] line = br.readLine().split(" ");

			int num = Integer.parseInt(line[0]);

			for (int j = 0; j < num; j++) {
				arr[i][j] = Integer.parseInt(line[j + 1]);
			}

			for (int j = 0; j < num; j++) {
				for (int k = j + 1; k < num; k++) {
					g[arr[i][j]][arr[i][k]] = 1;
					g[arr[i][k]][arr[i][j]] = 1;
				}
			}
		}

		bfs(kSet);

		int res = 0;
		for (int i = 0; i < m; i++) {
			boolean flag = true;
			for (int j = 0; j < 50; j++) {
				if (arr[i][j] == 0)
					break;
				if (kSet.contains(arr[i][j]))
					flag = false;
			}
			if (flag)
				res++;
		}

		System.out.println(res);

		br.close();
	}

	private static void bfs(Set<Integer> kSet) {
		boolean[] v = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		for (Integer k : kSet) {
			v[k] = true;
			q.add(k);
		}

		while (!q.isEmpty()) {
			Integer cur = q.poll();

			for (int i = 1; i <= n; i++) {
				if (!v[i] && g[cur][i] == 1) {
					q.add(i);
					v[i] = true;
					kSet.add(i);
				}
			}
		}

	}
}
