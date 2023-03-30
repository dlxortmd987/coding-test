package programmers;

import java.util.*;

class Node {
	int x;
	int y;
	int count;

	public Node(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class 리코쳇로봇 {

	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	int w;
	int h;
	boolean[][] visited;

	private int bfs(int[] r, int[] g, String[] board) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r[0], r[1], 0));
		visited[r[1]][r[0]] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (g[0] == node.x && g[1] == node.y) {
				return node.count;
			}

			for (int i = 0; i < 4; i++) {
				int nx = node.x;
				int ny = node.y;
				while (nx + dx[i] >= 0 && nx + dx[i] < w && ny + dy[i] >= 0 && ny + dy[i] < h && board[ny + dy[i]].charAt(nx + dx[i]) != 'D') {
					nx += dx[i];
					ny += dy[i];
				}

				if (!visited[ny][nx]) {
					q.add(new Node(nx, ny, node.count + 1));
					visited[ny][nx] = true;
				}


			}
		}

		return -1;
	}


	public int solution(String[] board) {
		int answer = 0;

		h = board.length;
		w = board[0].length();
		visited = new boolean[h][w];

		int[] r = new int[2];
		int[] g = new int[2];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (board[i].charAt(j) == 'R') {
					r[0] = j;
					r[1] = i;
				}
				if (board[i].charAt(j) == 'G') {
					g[0] = j;
					g[1] = i;
				}
			}
		}

		return bfs(r, g, board);
	}
}