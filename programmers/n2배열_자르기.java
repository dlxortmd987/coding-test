package programmers;

import java.util.ArrayList;
import java.util.List;

public class n2배열_자르기 {
	public int[] solution(int n, long left, long right) {

		List<Integer> arr = new ArrayList<>();

		for (long i = left; i <= right; i++) {
			long k = i / n;
			long m = i % n;
			if (m <= k) arr.add((int)k+1);
			else arr.add((int)m+1);
		}

		int[] answer = arr.stream()
			.mapToInt(Integer::intValue)
			.toArray();
		return answer;
	}
}
