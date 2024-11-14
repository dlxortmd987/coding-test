package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[100][100];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]) - 1;
			int y = Integer.parseInt(line[1]) - 1;

			for (int j = y; j < y + 10; j++) {
				for (int k = x; k < x + 10; k++) {
					arr[j][k] = 1;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) {
					res++;
				}
			}
		}

		System.out.println(res);

		br.close();
	}
}
