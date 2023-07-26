package programmers;

import java.util.*;

public class 시소_짝꿍 {

	public static long solution(int[] weights) {
		long answer = 0;

		double[][] g = {{1.0, 1.0}, {2.0, 3.0}, {1.0, 2.0}, {3.0, 4.0}};

		Map<Double, Integer> hm = new HashMap<>();
		Arrays.sort(weights);

		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < 4; j++) {
				double p1 = (weights[i] * g[j][0]) / g[j][1];

				if (hm.containsKey(p1)) {
					answer += hm.get(p1);
				}

			}
			hm.put(weights[i]*1.0, hm.getOrDefault(weights[i]*1.0, 0) + 1);
		}

		return answer;
	}

	public static void main(String[] args) {

	}
}
