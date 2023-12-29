package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		int s = 0;

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			String op = line[0];

			if (op.equals("all")) {
				s = (1 << 21) - 1;
				continue;
			}

			if (op.equals("empty")) {
				s = 0;
				continue;
			}

			int x = Integer.parseInt(line[1]);

			if (op.equals("add")) {
				s |= (1 << x);
				continue;
			}

			if (op.equals("remove")) {
				s &= ~(1 << x);
				continue;
			}

			if (op.equals("check")) {
				sb.append((s & (1 << x)) != 0 ? 1 : 0).append('\n');
				continue;
			}

			s ^= (1 << x);
		}
		System.out.println(sb);

		br.close();
	}
}
