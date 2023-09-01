package code_tree.intermidiate_low.BFS.BFS_탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class 돌_잘_치우기 {

	static boolean[][] v;
	static Set<List<int[]>> samples = new HashSet<>();

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static int bfs(int x, int y, int[][] g) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		v[y][x] = true;
		int count = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= g.length || ny < 0 || ny >= g.length)
					continue;

				if (g[ny][nx] == 0 && !v[ny][nx]) {
					q.add(new int[] {nx, ny});
					v[ny][nx] = true;
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		int[][] g = new int[n][n];
		v = new boolean[n][n];
		List<int[]> rocks = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
				if (g[i][j] == 1) {
					rocks.add(new int[] {j, i});
				}
			}
		}

		boolean[] isSelected = new boolean[rocks.size()];
		select(rocks, m, new ArrayList<>(), isSelected);

		int answer = 0;
		for (int i = 0; i < k; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();

			for (List<int[]> selectedRocks : samples) {
				for (int[] rock : selectedRocks) {
					g[rock[1]][rock[0]] = 0;
				}

				int cur = bfs(x - 1, y - 1, g);
				answer = Math.max(answer, cur);
				v = new boolean[n][n];

				for (int[] rock : selectedRocks) {
					g[rock[1]][rock[0]] = 1;
				}
			}
		}

		System.out.println(answer);

	}

	public static void select(List<int[]> rocks, int m, List<int[]> cur, boolean[] isSelected) {
		if (cur.size() == m) {
			samples.add(cur);
			return;
		}

		for (int i = 0; i < rocks.size(); i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				List<int[]> newCur = new ArrayList<>(cur);
				newCur.add(rocks.get(i));
				select(rocks, m, newCur, Arrays.copyOf(isSelected, isSelected.length));
				isSelected[i] = false;
			}
		}
	}
}
