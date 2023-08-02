package programmers;

import java.util.*;

public class 테이블_해시_함수 {
	public int solution(int[][] data, int col, int row_begin, int row_end) {

		Arrays.sort(data, (o1, o2) -> {
			if (o1[col - 1] < o2[col - 1])
				return -1;
			else if (o1[col - 1] > o2[col - 1])
				return 1;

			if (o1[0] > o2[0])
				return -1;
			else if (o1[0] < o2[0])
				return 1;

			return 0;
		});

		// System.out.println(Arrays.deepToString(data));

		int answer = 0;

		for (int i = row_begin; i <= row_end; i++) {
			int t = 0;
			for (int j = 0; j < data[0].length; j++) {
				t += data[i - 1][j] % i;
			}
			answer ^= t;

		}

		return answer;
	}
}
