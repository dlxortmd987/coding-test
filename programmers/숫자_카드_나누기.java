package programmers;

public class 숫자_카드_나누기 {
	public int gcd(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		while (min != 0) {
			int ret = max % min;
			max = min;
			min = ret;
		}

		return max;
	}

	public int solution(int[] arrayA, int[] arrayB) {
		int a = arrayA[0];
		for (int i = 1; i < arrayA.length; i++) {
			a = gcd(a, arrayA[i]);
		}

		int b = arrayB[0];
		for (int i = 1; i < arrayB.length; i++) {
			b = gcd(b, arrayB[i]);
		}

		if ((a == 1 && b == 1) || a == b) return 0;

		boolean isDividedA = false;
		boolean isDividedB = false;

		if (a != 1) {
			for (int i = 0; i < arrayB.length; i++) {
				if (arrayB[i] % a == 0) {
					isDividedA = true;
					break;
				}
			}
		}

		if (b != 1) {
			for (int i = 0; i < arrayA.length; i++) {
				if (arrayA[i] % b == 0) {
					isDividedB = true;
					break;
				}
			}
		}

		if (isDividedA && isDividedB) return 0;
		else if (isDividedA && !isDividedB) return b == 1 ? 0 : b;
		else if (!isDividedA && isDividedB) return a == 1 ? 0 : a;

		return Math.max(a, b);
	}
}
