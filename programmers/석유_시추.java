package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class 석유_시추 {
	public static int solution(int[][] land) {
		int answer = 0;
		int[][] g = new int[land.length][land[0].length];
		int idx = 1;
		boolean[][] v = new boolean[land.length][land[0].length];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < land[0].length; i++) {
			for (int j = 0; j < land.length; j++) {
				if (!v[j][i] && land[j][i] == 1) {
					int size = bfs(land, v, i, j, g, idx);
					map.put(idx, size);
					idx++;
				}
			}
		}

		for (int i = 0; i < g[0].length; i++) {
			int sum = 0;
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < g.length; j++) {
				if (g[j][i] != 0)
					set.add(g[j][i]);
			}

			for (Integer j : set) {
				sum += map.get(j);
			}

			answer = Math.max(answer, sum);
		}

		return answer;
	}

	private static int bfs(int[][] land, boolean[][] v, int x, int y, int[][] g, int idx) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		v[y][x] = true;
		int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int res = 1;
		g[y][x] = idx;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];

				if (nx < 0 || nx >= land[0].length || ny < 0 || ny >= land.length)
					continue;

				if (!v[ny][nx] && land[ny][nx] == 1) {
					q.add(new int[] {nx, ny});
					v[ny][nx] = true;
					g[ny][nx] = idx;
					res++;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int solution = solution(new int[][] {
			{1, 1, 1, 1, 1, 1, 0, 0},
			{0, 1, 0, 0, 1, 1, 0, 0},
			{1, 1, 0, 0, 0, 1, 1, 0},
			{1, 1, 1, 0, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0, 1, 1}
		});
		System.out.println("solution = " + solution);
	}
}
