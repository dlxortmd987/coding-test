package programmers;

import java.util.*;

public class 행렬_테두리_회전하기 {

	static List<Integer> res = new ArrayList<>();

	public static int[][] rotate(int[][] g, int[] query) {
		Deque<Integer> q = new LinkedList<>();

		int min = 10001;

		for (int i = query[1]-1; i < query[3]; i++) {
			int k = g[query[0]-1][i];
			min = Math.min(k, min);
			q.add(k);
		}

		for (int i = query[0]; i < query[2]; i++) {
			int k = g[i][query[3]-1];
			min = Math.min(k, min);
			q.add(k);
		}

		for (int i = query[3]-2; i >= query[1]-1; i--) {
			int k = g[query[2]-1][i];
			min = Math.min(k, min);
			q.add(k);
		}

		for (int i = query[2]-2; i > query[0]-1; i--) {
			int k = g[i][query[1]-1];
			min = Math.min(k, min);
			q.add(k);
		}
		// System.out.println(q);
		res.add(min);

		q.addFirst(q.pollLast());

		// System.out.println(q);

		for (int i = query[1]-1; i < query[3]; i++) {
			g[query[0]-1][i] = q.poll();
		}

		for (int i = query[0]; i < query[2]; i++) {
			g[i][query[3]-1] = q.poll();
		}

		for (int i = query[3]-2; i >= query[1]-1; i--) {
			g[query[2]-1][i] = q.poll();
		}

		for (int i = query[2]-2; i > query[0]-1; i--) {
			g[i][query[1]-1] = q.poll();
		}

		// System.out.println(Arrays.deepToString(g));

		return g;
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		int[][] g = new int[rows][columns];

		int k = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				g[i][j] = k++;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			g = rotate(g, queries[i]);
		}

		// System.out.println(Arrays.deepToString(g));

		for (int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}

		return answer;
	}


	public static void main(String[] args) {

	}
}
