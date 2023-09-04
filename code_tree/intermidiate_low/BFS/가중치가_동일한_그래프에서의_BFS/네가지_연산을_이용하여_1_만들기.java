package code_tree.intermidiate_low.BFS.가중치가_동일한_그래프에서의_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 네가지_연산을_이용하여_1_만들기 {

	static int answer = Integer.MAX_VALUE;
	static boolean[] v = new boolean[3_000_001];

	private static void bfs(int n) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n, 0});
		v[n] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int curN = operate(cur[0], i);
				if (!v[curN] && curN > 0) {
					if (curN == 1) {
						answer = Math.min(answer, cur[1] + 1);
						return;
					}
					v[curN] = true;
					q.add(new int[] {curN, cur[1] + 1});
				}
			}
		}
	}

	private static int operate(int n, int type) {
		int result = n;
		switch (type) {
			case 0:
				result += 1;
				break;
			case 1:
				result -= 1;
				break;
			case 2:
				if (n % 2 == 0)
					result /= 2;
				break;
			case 3:
				if (n % 3 == 0)
					result /= 3;
				break;
			default:
				break;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (n == 1) {
			System.out.println(0);
			return;
		}

		bfs(n);

		System.out.println(answer);
	}
}
