package code_tree.intermidiate_low.Backtracking.격자_안에서_완전_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최고의_33위치 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int[][] g = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] raw = bf.readLine().split(" ");
			for (int j = 0; j < raw.length; j++) {
				g[i][j] = Integer.parseInt(raw[j]);
			}
		}
		int answer = 0;
		for (int i = 0; i < n-2; i++) {
			for (int j = 0; j < n-2; j++) {
				int count = 0;
				for (int y = 0; y < 3; y++) {
					for (int x = 0; x < 3; x++) {
						if (g[i + y][j + x] == 1) {
							count++;
						}
					}
				}
				answer = Math.max(answer, count);
			}
		}

		System.out.println(answer);
	}
}
