package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		String[] line = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}

		int[] hap = new int[n + 1];
		hap[0] = 0;
		for (int i = 1; i <= n; i++) {
			hap[i] += hap[i - 1] + arr[i - 1];
		}

		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < m; k++) {
			String[] ij = br.readLine().split(" ");
			int i = Integer.parseInt(ij[1]);
			int j = Integer.parseInt(ij[0]) - 1;
			sb.append(hap[i] - hap[j]).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
