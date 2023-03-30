package programmers;

import java.util.*;

class 정수삼각형 {
	public int solution(int[][] triangle) {
		int answer = 0;

		List<int[]> tree = new ArrayList<>();
		tree.add(new int[] {triangle[0][0]});


		for (int i = 1; i < triangle.length; i++) {
			int[] arr = triangle[i];
			int[] prev = tree.get(i-1);
			int[] temp = new int[arr.length];


			for (int j = 0; j < arr.length; j++) {
				int left = 0;
				int right = 0;

				if (j > 0) left = prev[j-1];
				if (j < prev.length) right = prev[j];
				// System.out.println("left: " + left + ", right: " + right);

				temp[j] = Math.max(left + arr[j], right + arr[j]);
				if (i == triangle.length-1) {
					answer = Math.max(temp[j], answer);
				}
			}
			tree.add(temp);
		}

		return answer;
	}
}