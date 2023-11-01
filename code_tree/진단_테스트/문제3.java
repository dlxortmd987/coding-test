package code_tree.진단_테스트;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 문제3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int key = sc.nextInt();
			List<Integer> temp = map.getOrDefault(key, new ArrayList<>());
			temp.add(i);
			map.put(key, temp);
			arr[i] = key;
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			int count = 0;
			List<Integer> temp = map.getOrDefault(arr[i] + 1, new ArrayList<>());

			for (Integer t : temp) {
				if (i < t)
					count++;
			}
			res += count;
		}
		System.out.println(res);
	}
}
