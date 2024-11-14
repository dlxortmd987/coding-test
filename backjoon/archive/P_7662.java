package backjoon.archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class P_7662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for (int j = 0; j < k; j++) {
				String[] line = br.readLine().split(" ");

				int n = Integer.parseInt(line[1]);
				if (line[0].equals("I")) {
					map.put(n, map.getOrDefault(n, 0) + 1);
				} else {
					if (map.isEmpty())
						continue;
					Integer num;
					if (n == 1) {
						num = map.lastKey();
					} else {
						num = map.firstKey();
					}

					if (map.put(num, map.get(num) - 1) == 1) {
						map.remove(num);
					}
				}
			}
			if (map.isEmpty())
				System.out.println("EMPTY");
			else
				System.out.printf("%d %d\n", map.lastKey(), map.firstKey());
		}

		br.close();
	}
}
