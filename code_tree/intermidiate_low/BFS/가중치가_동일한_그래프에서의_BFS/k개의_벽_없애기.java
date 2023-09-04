package code_tree.intermidiate_low.BFS.가중치가_동일한_그래프에서의_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class k개의_벽_없애기 {

	static int[][] g;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Set<List<String>> s = new HashSet<>();

	private static int bfs(int x1, int y1, int x2, int y2) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x1, y1, 0});
		v[y1][x1] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[1] == y2 && cur[0] == x2) {
				return cur[2];
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= g[0].length || ny < 0 || ny >= g.length)
					continue;

				if (!v[ny][nx] && g[ny][nx] == 0) {
					q.add(new int[] {nx, ny, cur[2] + 1});
					v[ny][nx] = true;
				}
			}
		}

		return Integer.MAX_VALUE;
	}

	private static void comb(List<int[]> walls, int k, List<String> cur, boolean[] isS) {
		if (cur.size() == k) {
			Collections.sort(cur);
			s.add(cur);
			return;
		}

		for (int i = 0; i < walls.size(); i++) {
			if (!isS[i]) {
				isS[i] = true;
				List<String> ccur = new ArrayList<>(cur);
				ccur.add(convert(walls.get(i)));
				comb(walls, k, ccur, isS);
				isS[i] = false;
			}
		}
	}

	private static String convert(int[] coor) {
		return String.format("%d,%d", coor[0], coor[1]);
	}

	private static int[] convert(String coor) {
		String[] raw = coor.split(",");
		int[] res = new int[raw.length];
		for (int i = 0; i < raw.length; i++) {
			res[i] = Integer.parseInt(raw[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		g = new int[n][n];

		List<int[]> walls = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g[i][j] = sc.nextInt();
				if (g[i][j] == 1) {
					walls.add(new int[] {j, i});
				}
			}
		}

		int y1 = sc.nextInt();
		int x1 = sc.nextInt();
		int y2 = sc.nextInt();
		int x2 = sc.nextInt();

		boolean[] isS = new boolean[walls.size()];
		comb(walls, k, new ArrayList<>(), isS);

		Set<List<int[]>> samples = new HashSet<>();
		for (List<String> sample : s) {
			List<int[]> buf = new ArrayList<>();
			for (String wall : sample) {
				buf.add(convert(wall));
			}
			samples.add(buf);
		}

		int answer = Integer.MAX_VALUE;
		for (List<int[]> sample : samples) {
			for (int[] wall : sample) {
				g[wall[1]][wall[0]] = 0;
			}
			v = new boolean[n][n];
			answer = Math.min(bfs(x1 - 1, y1 - 1, x2 - 1, y2 - 1), answer);

			for (int[] wall : sample) {
				g[wall[1]][wall[0]] = 1;
			}
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}
