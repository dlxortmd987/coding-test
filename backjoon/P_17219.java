package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P_17219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			map.put(line[0], line[1]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String id = br.readLine();
			sb.append(map.get(id)).append('\n');
		}

		System.out.println(sb);

		br.close();
	}
}
