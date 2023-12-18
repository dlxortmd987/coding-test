package backjoon;

import static java.lang.Integer.*;
import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		int n = parseInt(br.readLine());

		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] raw = br.readLine().split(" ");
			arr[i] = new int[] {Integer.parseInt(raw[0]), Integer.parseInt(raw[1])};
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] - o2[1] == 0)
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});

		int res = 1;
		int t = arr[0][1];
		for (int i = 1; i < n; i++) {
			if (t > arr[i][0]) {
				continue;
			}

			t = arr[i][1];
			res++;
		}

		out.println(res);

		br.close();
	}
}
