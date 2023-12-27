package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_20529 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			String[] line = br.readLine().split(" ");

			if (n > 33) {
				System.out.println(0);
				continue;
			}

			int res = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					for (int l = k + 1; l < n; l++) {
						int sum = 0;
						for (int m = 0; m < 4; m++) {
							sum += line[j].charAt(m) == line[k].charAt(m) ? 0 : 1;
							sum += line[j].charAt(m) == line[l].charAt(m) ? 0 : 1;
							sum += line[k].charAt(m) == line[l].charAt(m) ? 0 : 1;
						}

						res = Math.min(sum, res);
					}
				}
			}

			System.out.println(res);
		}

		br.close();
	}
}
