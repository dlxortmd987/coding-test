package code_tree.intermidiate_low.BFS.BFS_탐색;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class 우리는_하나 {

	static boolean[][] v;
	static int[][] g;
	static Set<List<String>> s = new HashSet<>();

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int u = sc.nextInt();
		int d = sc.nextInt();

		g = new int[n][n];

		List<int[]> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
				arr.add(new int[] {j, i});
			}
		}

		boolean[] isS = new boolean[arr.size()];
		select(arr, k, new ArrayList<>(), isS);

		int answer = 0;
		for (List<String> starts : s) {
			Set<String> set = new HashSet<>();
			for (String start : starts) {
				v = new boolean[n][n];
				List<int[]> list = bfs(start, u, d);
				List<String> stringList = list.stream()
					.map(i -> String.format("%d,%d", i[0], i[1]))
					.collect(Collectors.toList());

				set.addAll(stringList);
			}
			answer = Math.max(answer, set.size());
		}

		System.out.println(answer);
	}

	private static List<int[]> bfs(String rawStart, int u, int d) {
		String[] stringStart = rawStart.split(",");
		int[] start = new int[stringStart.length];
		for (int i = 0; i < stringStart.length; i++) {
			start[i] = Integer.parseInt(stringStart[i]);
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		v[start[1]][start[0]] = true;
		List<int[]> res = new ArrayList<>();
		res.add(start);

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int v1 = g[cur[1]][cur[0]];

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= g.length || ny < 0 || ny >= g.length)
					continue;
				int v2 = g[ny][nx];
				int diff = Math.abs(v2 - v1);

				if (diff <= d && diff >= u && !v[ny][nx]) {
					int[] next = {nx, ny};
					q.add(next);
					v[ny][nx] = true;
					res.add(next);
				}
			}
		}

		return res;
	}

	private static void select(List<int[]> arr, int k, List<String> cur, boolean[] isS) {
		if (cur.size() == k) {
			cur.sort(String::compareTo);
			s.add(cur);
			return;
		}

		for (int i = 0; i < arr.size(); i++) {
			if (!isS[i]) {
				isS[i] = true;
				List<String> ccur = new ArrayList<>(cur);
				int[] tokens = arr.get(i);
				ccur.add(String.format("%d,%d", tokens[0], tokens[1]));

				select(arr, k, ccur, isS);
				isS[i] = false;
			}
		}
	}

}
